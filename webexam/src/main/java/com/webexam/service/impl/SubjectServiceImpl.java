package com.webexam.service.impl;

import com.pandawork.core.excel.DataType;
import com.pandawork.core.excel.ExcelReader;
import com.pandawork.core.excel.ExcelWriter;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.pandawork.core.util.Pagination;
import com.webexam.common.entity.Subject;
import com.webexam.common.exception.WebexamException;
import com.webexam.common.service.impl.BaseServiceImpl;
import com.webexam.mapper.SubjectMapper;
import com.webexam.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SubjectServiceImpl
 *
 * @author: zhangteng
 * @time: 14-1-16 下午2:40
 */
@Service("subjectService")
public class SubjectServiceImpl extends BaseServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> queryAll() throws SSException {
        try {
            return subjectMapper.queryAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public int queryCount() throws SSException {
        try {
            return commonDao.queryCount(Subject.class);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public List<Subject> queryByPage(Pagination page) throws SSException {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            int pCurrent = 0, pSize = 10;
            if(page != null) {
                pCurrent = page.getCurrentFristPosition();
                pSize = page.getPageSize();
            }
            params.put("pCurrent", pCurrent);
            params.put("pSize", pSize);
            List<Subject> subjectList = subjectMapper.queryByPage(params);
            return subjectList;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public void batchInsert(File file) throws SSException {
        DataType[] dataTypes = {
                new DataType("code", 0),
                new DataType("name", 1),
                new DataType("credit", 2)
        };
        try {
            List<Subject> subjectList = (List) ExcelReader.readExcele(Subject.class, file, 1, dataTypes);
            commonDao.insertAll(subjectList);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        }
    }

    @Override
    @Async
    public void batchOutput() throws SSException {
        DataType[] dataTypes = {
                new DataType("code", 0),
                new DataType("name", 1),
                new DataType("credit", 2)
        };
        DataType[] headDatas = {
                new DataType("专业代码", 0),
                new DataType("专业名称", 1),
                new DataType("学分", 2)
        };
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\webexam\\test.xls"));
            List<Subject> subjectList = this.queryAll();
            ExcelWriter.writeExcel(subjectList, "专业", bos, headDatas, dataTypes);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        }
    }
}
