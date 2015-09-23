package com.webexam.service.impl;

import com.pandawork.core.excel.DataType;
import com.pandawork.core.excel.ExcelReader;
import com.pandawork.core.excel.ExcelWriter;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.pandawork.core.util.Pagination;
import com.webexam.common.cache.ProblemCache;
import com.webexam.common.dto.StudentBatchDto;
import com.webexam.common.dto.StudentDto;
import com.webexam.common.dto.StudentInsertDto;
import com.webexam.common.entity.Problem;
import com.webexam.common.entity.Student;
import com.webexam.common.entity.StudentSubject;
import com.webexam.common.entity.WebExam;
import com.webexam.common.exception.WebexamException;
import com.webexam.common.service.impl.BaseServiceImpl;
import com.webexam.mapper.StudentMapper;
import com.webexam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * StudentServiceImpl
 *
 * @author: zhangteng
 * @time: 14-1-27 下午12:08
 */
@Service("studentService")
public class StudentServiceImpl extends BaseServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    private static final int BATCH_SIZE = 20;

    @Override
    public void insertForList(List list) throws SSException {
        try {
            int runTimeIndex = 0, totalIndex = 0, listSize = list.size();
            Iterator it = list.iterator();
            if(listSize <= BATCH_SIZE) {
                studentMapper.insertForList(list);
                return ;
            }
            List tmpList = new ArrayList();
            while (it.hasNext()) {
                tmpList.add(it.next());
                runTimeIndex ++; totalIndex ++;
                if(runTimeIndex==BATCH_SIZE || totalIndex==listSize) {
                    studentMapper.insertForList(tmpList);
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
    public int queryCount() throws SSException {
        try {
            return commonDao.queryCount(Student.class);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public List<Student> queryByPage(Pagination page) throws SSException {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            int pCurrent = 0, pSize = 10;
            if(page != null) {
                pCurrent = page.getCurrentFristPosition();
                pSize = page.getPageSize();
            }
            params.put("pCurrent", pCurrent);
            params.put("pSize", pSize);
            List<Student> studentList = studentMapper.queryByPage(params);
            return studentList;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public Student insertStudent(Student student) throws SSException {
        boolean isExist = false;
        try {
            int count = studentMapper.queryCountByExamNo(student.getExamNo());
            if(count != 0) {
                isExist = true;
                throw SSException.get(WebexamException.StudentExist);
            } else {
                return this.insert(student);
            }
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            if(isExist) {
                throw SSException.get(WebexamException.StudentExist);
            } else {
                throw SSException.get(WebexamException.InserFail);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public void batchInsert(File file) throws SSException {
        DataType[] dataTypes = {
                new DataType("examNo", 0), new DataType("name", 1), new DataType("idNo", 2), new DataType("schoolName", 3),
                new DataType("majorCode", 4), new DataType("majorName", 5), new DataType("subjectCode", 6),
                new DataType("subjectName", 7), new DataType("isPay", 8), new DataType("payTime", 9),
                new DataType("score", 10), new DataType("isShowScore", 11)
        };
        List<StudentDto> studentDtoList = new ArrayList<StudentDto>();
        try {
            List<StudentBatchDto> studentBatchDtoList = (List) ExcelReader.readExcele(StudentBatchDto.class, file, 1, dataTypes);

            Map<String, Integer> userMap = new HashMap<String, Integer>();
            for(StudentBatchDto dto : studentBatchDtoList) {
                if(dto == null) {
                    continue;
                }
                if(dto.getExamNo() == null || dto.getExamNo().equalsIgnoreCase("")) {
                    continue;
                }
                if(dto.getName() == null || dto.getName().equalsIgnoreCase("")) {
                    continue;
                }
                if(userMap.get(dto.getExamNo()) == null) {
                    userMap.put(dto.getExamNo(), studentDtoList.size());
                    StudentDto studentDto = new StudentDto();
                    studentDto.setStudent(new Student(dto.getExamNo(), dto.getIdNo(), dto.getName(), dto.getMajorCode(), dto.getMajorName(), dto.getSchoolName()));
                    studentDto.addSubject(new StudentSubject(dto.getSubjectCode(), dto.getSubjectName(), dto.getIsPay(), dto.getPayTime(), dto.getScore(), dto.getIsShowScore()));
                    studentDtoList.add(studentDto);
                } else {
                    StudentDto studentDto = studentDtoList.get(userMap.get(dto.getExamNo()));
                    studentDto.addSubject(new StudentSubject(dto.getSubjectCode(), dto.getSubjectName(), dto.getIsPay(), dto.getPayTime(), dto.getScore(), dto.getIsShowScore()));
                }
            }

            for(StudentDto studentDto : studentDtoList) {
                // 根据学号删除原有学生的信息，包括t_student表和t_student_subject表
                Student stu = studentDto.getStudent();
                Student student = this.login(stu.getExamNo(), stu.getName(), stu.getMajorCode());
                if(student != null) {
                    this.delete(student);
                    this.deleteSubjectByStudentId(student.getId());
                }
                stu = this.insert(stu);
                for(StudentSubject stuSub : studentDto.getSubjectList()) {
                    stuSub.setStudentId(stu.getId());
                }
                this.insertForList(studentDto.getSubjectList());
            }
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        }
    }

    @Override
    public void batchExportByMajor(String majorCode, HttpServletResponse response) throws SSException {
        OutputStream os = null;
        DataType[] dataTypes = {
                new DataType("examNo", 0), new DataType("name", 1), new DataType("idNo", 2), new DataType("schoolName", 3),
                new DataType("majorCode", 4), new DataType("majorName", 5), new DataType("subjectCode", 6),
                new DataType("subjectName", 7), new DataType("isPay", 8), new DataType("payTime", 9),
                new DataType("score", 10), new DataType("isShowScore", 11)
        };
        DataType[] headDatas = {
                new DataType("准考证号", 0), new DataType("姓名", 1), new DataType("身份证号", 2), new DataType("学校/机构", 3),
                new DataType("专业代码", 4), new DataType("专业名称", 5), new DataType("科目代码", 6),
                new DataType("科目名称", 7), new DataType("是否缴费(0-未缴费,1-缴费)", 8), new DataType("缴费时间", 9),
                new DataType("成绩", 10), new DataType("是否显示成绩(0-不显示,1-显示)", 11)
        };
        try {
            // 从数据库中取出数据
            List<StudentBatchDto> studentList = studentMapper.queryExportByMajor(majorCode);

            String filename = studentList.get(0).getMajorName() + "学生信息";
            String contentType = "application/octet-stream";
            response.setContentType(contentType);
            response.setHeader("Content-disposition",
                    "attachment; filename=" + new String(filename.getBytes("gbk"), "ISO8859-1") + ".xls");
            os = response.getOutputStream();

            // 导出到excel
            ExcelWriter.writeExcel(studentList, "学生信息", os, headDatas, dataTypes);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        } finally {
            if(os != null) {
                try {
                    os.close();;
                } catch (Exception e) {
                    LogClerk.errLog.equals(e);
                    throw SSException.get(WebexamException.ExportFail);
                }
            }
        }
    }

    @Override
    public StudentDto queryDtoById(Integer id) throws SSException {
        try {
            return studentMapper.queryDtoById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public List<Student> queryBySearch(String search) throws SSException {
        try {
            return studentMapper.queryBySearch(search);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public List<Student> queryByMajor(String majorCode) throws SSException {
        try {
            return studentMapper.queryByMajor(majorCode);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public void deleteSubjectByStudentId(Integer sid) throws SSException {
        try {
            studentMapper.delSubjectByStudentId(sid);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.DeleteFail);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public void updateStudentSubject(StudentDto studentDto) throws SSException {
        try {
            this.update(studentDto.getStudent());
            this.deleteSubjectByStudentId(studentDto.getStudent().getId());
            List<StudentSubject> subjectList = studentDto.getSubjectList();
            // insertAll有bug，先改成一条一条插
            for(StudentSubject studentSubject : subjectList) {
                this.insert(studentSubject);
            }
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        }
    }

    @Override
    public Student queryStudentByExamNo(String examNo) throws SSException {
        try {
            return studentMapper.queryStudentByExamNo(examNo);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        }
    }

    /* ------ 以下方法只用于前端考试页面 ------- */

    @Override
    public Student login(String examNo, String name, String majorCode) throws SSException {
        try {
            System.out.println(examNo + " " + name + " " + majorCode);
            return studentMapper.login(examNo, name, majorCode);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        }
    }

    @Override
    public List<WebExam> queryExamById(Integer id) throws SSException {
        try {
            Student student = this.queryById(Student.class, id);
            Date date = new Date();
            return studentMapper.queryExamById(id, student.getMajorCode(), date);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public StudentSubject querySubjectBySidAndSubject(Integer sid, String subjectCode) throws SSException {
        try {
            return studentMapper.querySubjectBySidAndSubject(sid, subjectCode);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        }
    }

    @Override
    @Async
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public void calculateScore(Integer id, List<Integer> problemIds, List<String[]> answers, String majorCode, String subjectCode) throws SSException {
        try {
            // 暂停2秒
            Thread.sleep(2000);
            // 先从缓存中取出对应专业-科目的所有题目
            List<Problem> problemList = ProblemCache.getProblemsByMajorAndSub(majorCode, subjectCode);
            // 为了方便根据id进行查找，将题目放入map
            Map<Integer, Problem> idMap = new HashMap<Integer, Problem>();
            for(Problem p : problemList) {
                idMap.put(p.getId(), p);
            }

            // 算成绩
            Integer score = 0;
            int pIdSize = problemIds.size();
            for(int i = 0;i < pIdSize; ++i) {
                Problem problem = idMap.get(problemIds.get(i));
                String[] ansTemp = answers.get(i);
                String answer = "";
                for(String s : ansTemp) {
                    answer += s;
                }
                if (answer.equalsIgnoreCase(problem.getAnswer())) {
                   score += problem.getScore();
                }
            }

            // 更新学生-科目表
            StudentSubject studentSubject = studentMapper.querySubjectBySidAndSubject(id, subjectCode);
            studentSubject.setScore(score);
            this.update(studentSubject);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        }
    }
}
