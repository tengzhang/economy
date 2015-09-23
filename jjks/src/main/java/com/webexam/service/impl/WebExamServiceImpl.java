package com.webexam.service.impl;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.pandawork.core.util.Pagination;
import com.webexam.common.entity.WebExam;
import com.webexam.common.exception.WebexamException;
import com.webexam.common.service.impl.BaseServiceImpl;
import com.webexam.mapper.WebExamMapper;
import com.webexam.service.WebExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WebExamServiceImpl
 *
 * @author: zhangteng
 * @time: 14-2-3 上午11:58
 */
@Service("webExamService")
public class WebExamServiceImpl extends BaseServiceImpl implements WebExamService {

    @Autowired
    private WebExamMapper webExamMapper;

    @Override
    public List<WebExam> queryAll() throws SSException {
        try {
            return webExamMapper.queryAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public int queryCount() throws SSException {
        try {
            return commonDao.queryCount(WebExam.class);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public List<WebExam> queryByPage(Pagination page) throws SSException {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            int pCurrent = 0, pSize = 0;
            if(page != null) {
                pCurrent = page.getCurrentFristPosition();
                pSize = page.getPageSize();
            }
            params.put("pCurrent", pCurrent);
            params.put("pSize", pSize);
            List<WebExam> webExamList = webExamMapper.queryByPage(params);
            return webExamList;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public List<WebExam> queryBySearch(String search) throws SSException {
        try {
            return webExamMapper.queryBySearch(search);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }

    @Override
    public WebExam queryExamByMajorAndSubject(String majorCode, String subject) throws SSException {
        try {
            List<WebExam> webExamList = webExamMapper.queryExamByMajorAndSubject(majorCode, subject, new Date());
            if(webExamList != null) {
                return webExamList.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }
}
