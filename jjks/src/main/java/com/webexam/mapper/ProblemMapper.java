package com.webexam.mapper;

import com.webexam.common.entity.Problem;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * ProblemMapper
 *
 * @author: zhangteng
 * @time: 14-2-5 下午11:48
 */
public interface ProblemMapper {

    public void insertForList(List<Problem> list);

    /**
     * 查询全部
     *
     * @return
     */
    public List<Problem> queryAll();

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    public List<Problem> queryByPage(Map<String, Object> params);

    /**
     * 根据专业代码和科目代码查询题目
     *
     * @param majorCode
     * @param subjectCode
     * @return
     */
    public List<Problem> queryByMajorAndSubject(@Param("majorCode") String majorCode,
                                                @Param("subjectCode") String subjectCode);

    /**
     * 查询数据库中包含哪些不同专业、科目的题目
     * 批量导出时用到
     *
     * @return
     */
    public List<Problem> queryDistinctProblem();

    /**
     * 根据专业代码和科目代码删除题目
     *
     * @param majorCode
     * @param subjectCode
     */
    public void deleteByMajorAndSubject(@Param("majorCode") String majorCode,
                                        @Param("subjectCode") String subjectCode);

    public void deleteByTitle(@Param("title") String title);
}
