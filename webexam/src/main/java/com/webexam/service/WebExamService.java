package com.webexam.service;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import com.webexam.common.entity.WebExam;
import com.webexam.common.service.BaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * WebExamService
 *
 * @author: zhangteng
 * @time: 14-2-3 上午11:57
 */
public interface WebExamService extends BaseService {

    /**
     * 查询全部
     *
     * @return
     * @throws SSException
     */
    public List<WebExam> queryAll() throws SSException;

    /**
     * 查询记录数
     *
     * @return
     * @throws SSException
     */
    public int queryCount() throws SSException;

    /**
     * 分页查询
     *
     * @param page
     * @return
     * @throws SSException
     */
    public List<WebExam> queryByPage(Pagination page) throws SSException;

    /**
     * 条件查询
     *
     * @param search
     * @return
     * @throws SSException
     */
    public List<WebExam> queryBySearch(String search) throws SSException;

    /**
     * 根据专业代码和科目代码查询正在进行的考试
     * 注意：数据库保存的同一专业、同一科目的正在进行的考试只有一门，否则只返回最后添加的一门
     *
     * @param majorCode
     * @param subject
     * @return
     */
    public WebExam queryExamByMajorAndSubject(String majorCode, String subject) throws SSException;
}
