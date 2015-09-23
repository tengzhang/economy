package com.webexam.service;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import com.webexam.common.entity.Problem;
import com.webexam.common.service.BaseService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * ProblemService
 *
 * @author: zhangteng
 * @time: 14-2-5 下午11:49
 */
public interface ProblemService extends BaseService {

    public void insertForList(List list) throws SSException;

    /**
     * 查询全部
     *
     * @return
     * @throws SSException
     */
    public List<Problem> queryAll() throws SSException;

    /**
     * 查询题目记录数
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
    public List<Problem> queryByPage(Pagination page) throws SSException;

    /**
     * 批量添加
     *
     * @param file
     * @throws SSException
     */
    public void batchInsert(File file) throws SSException;

    /**
     * 根据科目代码批量导出题目
     *
     * @param majorCode
     * @param subjectCode
     * @param response
     */
    public void batchExportByMajorAndSubject(String majorCode, String subjectCode, HttpServletResponse response) throws SSException;

    /**
     * 添加题目
     *
     * @param problem
     * @return
     * @throws SSException
     */
    public Problem insertProblem(Problem problem) throws SSException;

    /**
     * 更新题目
     *
     * @param problem
     * @throws SSException
     */
    public void updateProblem(Problem problem) throws SSException;

    /**
     * 删除题目
     *
     * @param id
     * @throws SSException
     */
    public void deleteById(Integer id) throws SSException;

    /**
     * 根据专业代码和科目代码获取题目
     *
     * @param majorCode
     * @param subjectCode
     * @return
     * @throws SSException
     */
    public List<Problem> queryProblemByMajorAndSub(String majorCode, String subjectCode) throws SSException;

    /**
     * 查询数据库中包含哪些不同专业、科目的题目
     * 批量导出时用到
     *
     * @return
     * @throws SSException
     */
    public List<Problem> queryDistinctProblem() throws SSException;
    /*-------- 前端用到的方法 --------*/

    /**
     * 随机获得50道题目
     *
     * @param majorCode
     * @param subjectCode
     * @return
     * @throws SSException
     */
    public List<Problem> getRandomProblems(String majorCode, String subjectCode) throws SSException;
}
