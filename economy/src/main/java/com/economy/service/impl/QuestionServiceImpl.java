package com.economy.service.impl;

import com.economy.common.entity.Question;
import com.economy.common.exception.EconomyException;
import com.economy.common.service.impl.BaseServiceImpl;
import com.economy.mapper.QuestionMapper;
import com.economy.service.QuestionService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.pandawork.core.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常见问题service实现
 *
 * @author: zhangteng
 * @time: 2014/4/11 10:51
 */
@Service("questionService")
public class QuestionServiceImpl extends BaseServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public int queryCountByCondition(String search) throws SSException {
        try {
            return questionMapper.queryCountByCondition(search);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public List<Question> queryByPage(Pagination page) throws SSException {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            int pCurrent = 0, pSize = 10;
            if(page != null) {
                pCurrent = page.getCurrentFristPosition();
                pSize = page.getPageSize();
            }
            params.put("pCurrent", pCurrent);
            params.put("pSize", pSize);
            List<Question> questionList = questionMapper.queryByPage(params);
            return questionList;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public List<Question> queryByCondition(Pagination page, String search) throws SSException {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            int pCurrent = 0, pSize = 10;
            if(page != null) {
                pCurrent = page.getCurrentFristPosition();
                pSize = page.getPageSize();
            }
            params.put("pCurrent", pCurrent);
            params.put("pSize", pSize);
            params.put("search", search);
            List<Question> questionList = questionMapper.queryByCondition(params);
            return questionList;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public Question insertQuestion(Question question) throws SSException {
        try {
            question.setPublicTime(new Date());
            return this.insert(question);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.InserFail);
        }
    }
}
