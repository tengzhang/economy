package com.economy.service;

import com.economy.common.entity.Question;
import com.economy.common.service.BaseService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;

import java.util.List;

/**
 * 常见问题service
 *
 * @author: zhangteng
 * @time: 2014/4/11 10:51
 */
public interface QuestionService extends BaseService {

    /**
     * 查询问题条数
     *
     * @param search
     * @return
     * @throws SSException
     */
    public int queryCountByCondition(String search) throws SSException;

    /**
     * 分页查询
     *
     * @param page
     * @return
     * @throws SSException
     */
    public List<Question> queryByPage(Pagination page) throws SSException;

    /**
     * 条件查询
     *
     * @param page
     * @param search
     * @return
     * @throws SSException
     */
    public List<Question> queryByCondition(Pagination page, String search) throws SSException;

    /**
     * 添加问题
     *
     * @param question
     * @return
     */
    public Question insertQuestion(Question question) throws SSException;
}
