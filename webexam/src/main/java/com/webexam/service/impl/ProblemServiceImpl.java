package com.webexam.service.impl;

import com.pandawork.core.excel.DataType;
import com.pandawork.core.excel.ExcelReader;
import com.pandawork.core.excel.ExcelWriter;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.pandawork.core.util.Pagination;
import com.webexam.common.cache.ProblemCache;
import com.webexam.common.entity.Problem;
import com.webexam.common.exception.WebexamException;
import com.webexam.common.service.impl.BaseServiceImpl;
import com.webexam.common.utils.RandomUtil;
import com.webexam.mapper.ProblemMapper;
import com.webexam.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * ProblemServiceImpl
 *
 * @author: zhangteng
 * @time: 14-2-5 下午11:49
 */
@Service("problemService")
public class ProblemServiceImpl extends BaseServiceImpl implements ProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    private static final int BATCH_SIZE = 20;

    @Override
    public void insertForList(List list) throws SSException {
        try {
            int runTimeIndex = 0, totalIndex = 0, listSize = list.size();
            Iterator it = list.iterator();
            if(listSize <= BATCH_SIZE) {
                problemMapper.insertForList(list);
                return ;
            }
            List tmpList = new ArrayList();
            while (it.hasNext()) {
                tmpList.add(it.next());
                runTimeIndex ++; totalIndex ++;
                if(runTimeIndex==BATCH_SIZE || totalIndex==listSize) {
                    problemMapper.insertForList(tmpList);
                    tmpList.clear();
                    runTimeIndex = 0;

                    // 休息一下
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        }
    }

    @Override
    public List<Problem> queryAll() throws SSException {
        try {
            return problemMapper.queryAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public int queryCount() throws SSException {
        try {
            return commonDao.queryCount(Problem.class);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public List<Problem> queryByPage(Pagination page) throws SSException {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            int pCurrent = 0, pSize = 0;
            if(page != null) {
                pCurrent = page.getCurrentFristPosition();
                pSize =page.getPageSize();
            }
            params.put("pCurrent", pCurrent);
            params.put("pSize", pSize);
            List<Problem> problemList = problemMapper.queryByPage(params);
            return problemList;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public void batchInsert(File file) throws SSException {
        DataType[] dataTypes = {
            new DataType("type", 0), new DataType("majorCode", 1),
            new DataType("majorName", 2), new DataType("subjectCode", 3),
            new DataType("subjectName", 4), new DataType("title", 5),
            new DataType("chooseA", 6), new DataType("chooseB", 7),
            new DataType("chooseC", 8), new DataType("chooseD", 9),
            new DataType("chooseE", 10), new DataType("answer", 11),
            new DataType("score", 12)
        };
        try {
            List<Problem> problemList = (List) ExcelReader.readExcele(Problem.class, file, 1, dataTypes);
            // 添加之前，先对数据进行处理，为null的全部设为""
            Field[] fields = Problem.class.getDeclaredFields();
            List<Field> checkFields = new ArrayList<Field>();
            for(Field f : fields) {
                if(f.getName() != "id" && f.getName() != "score" && f.getName() != "serialVersionUID" && f.getName() != "type") {
                    checkFields.add(f);
                }
            }
            for(Problem p : problemList) {
                for(Field f : checkFields) {
                    f.setAccessible(true);
                    if (f.get(p) == null) {
                        f.set(p, "");
                    }
                }
            }

            String majorCode = problemList.get(0).getMajorCode();
            String subjectCode = problemList.get(0).getSubjectCode();
            // 先删除原来数据库中的记录
            problemMapper.deleteByMajorAndSubject(majorCode, subjectCode);
            // 插入新导入的
            this.insertForList(problemList);

            problemList = problemMapper.queryByMajorAndSubject(majorCode, subjectCode);
            // 更新缓存
            ProblemCache.putProblems(problemList);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        }
    }

    @Override
    public void batchExportByMajorAndSubject(String majorCode, String subjectCode, HttpServletResponse response) throws SSException {
        OutputStream os = null;
        DataType[] dataTypes = {
                new DataType("type", 0), new DataType("majorCode", 1),
                new DataType("majorName", 2), new DataType("subjectCode", 3),
                new DataType("subjectName", 4), new DataType("title", 5),
                new DataType("chooseA", 6), new DataType("chooseB", 7),
                new DataType("chooseC", 8), new DataType("chooseD", 9),
                new DataType("chooseE", 10), new DataType("answer", 11),
                new DataType("score", 12)
        };
        DataType[] headDatas = {
                new DataType("题目类型", 0), new DataType("专业代码", 1),
                new DataType("专业名称", 2), new DataType("科目代码", 3),
                new DataType("科目名称", 4), new DataType("题干", 5),
                new DataType("选项A", 6), new DataType("选项B", 7),
                new DataType("选项C", 8), new DataType("选项D", 9),
                new DataType("选项E", 10), new DataType("答案", 11),
                new DataType("分值", 12)
        };
        try {
            // 从数据库中取出数据
            List<Problem> problemList = problemMapper.queryByMajorAndSubject(majorCode, subjectCode);

            String filename = problemList.get(0).getMajorName() + "-" + problemList.get(0).getSubjectName() + "题目";
            String contentType = "application/octet-stream";
            response.setContentType(contentType);
            response.setHeader("Content-disposition",
                    "attachment; filename=" + new String(filename.getBytes("gbk"), "ISO8859-1") + ".xls");
            os = response.getOutputStream();

            // 导出到excel
            ExcelWriter.writeExcel(problemList, "题目", os, headDatas, dataTypes);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.ExportFail);
        } finally {
            if(os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                    LogClerk.errLog.equals(e);
                    throw SSException.get(WebexamException.ExportFail);
                }
            }
        }
    }

    @Override
    public Problem insertProblem(Problem problem) throws SSException {
        try {
            // 先添加到数据库
            problem = this.insert(problem);
            // 添加到缓存
            ProblemCache.putProblem(problem);
            return problem;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.InserFail);
        }
    }

    @Override
    public void updateProblem(Problem problem) throws SSException {
        try {
            // 先更新数据库
            this.update(problem);
            // 再更新缓存
            ProblemCache.putProblem(problem);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.UpdateFail);
        }
    }

    @Override
    public void deleteById(Integer id) throws SSException {
        try {
            // 先删除数据库
            Problem problem = this.queryById(Problem.class, id);
            this.delete(problem);
            // 再删除缓存
            ProblemCache.removeProblem(problem);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.DeleteFail);
        }
    }

    @Override
    public List<Problem> queryProblemByMajorAndSub(String majorCode, String subjectCode) throws SSException {
        try {
            List<Problem> problemList = ProblemCache.getProblemsByMajorAndSub(majorCode, subjectCode);
            // 缓存中无记录，先从数据库中取，并加入缓存
            if(problemList == null) {
                problemList = problemMapper.queryByMajorAndSubject(majorCode, subjectCode);
                ProblemCache.putProblems(problemList);
            }
            return problemList;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public List<Problem> queryDistinctProblem() throws SSException {
        try {
            return problemMapper.queryDistinctProblem();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        }
    }

    /*-------- 前端用到的方法 --------*/

    @Override
    public List<Problem> getRandomProblems(String majorCode, String subjectCode) throws SSException {
        try {
            List<Problem> problemList = queryProblemByMajorAndSub(majorCode, subjectCode);
            int problemNumber = problemList.size() < 50 ? problemList.size() : 50;
            int[] problemIndexes = RandomUtil.getRandomNumbers(problemList.size()-1, problemNumber);
            List<Problem> list = new ArrayList<Problem>();
            for(int ix : problemIndexes) {
                list.add(problemList.get(ix));
            }
            return list;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        }
    }
}
