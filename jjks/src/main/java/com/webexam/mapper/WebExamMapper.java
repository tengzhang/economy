package com.webexam.mapper;

import com.webexam.common.entity.WebExam;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * WebExamMapper
 *
 * @author: zhangteng
 * @time: 14-2-3 上午11:57
 */
public interface WebExamMapper {

    /**
     * 查询全部
     *
     * @return
     */
    public List<WebExam> queryAll();

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    public List<WebExam> queryByPage(Map<String, Object> params);

    /**
     * 条件查询
     *
     * @param search
     * @return
     */
    public List<WebExam> queryBySearch(@Param("search") String search);

    /**
     * 根据专业代码和科目代码查询正在进行的考试
     *
     * @param majorCode
     * @param subjectCode
     * @param time
     * @return
     */
    public List<WebExam> queryExamByMajorAndSubject(@Param("majorCode") String majorCode,
                                                    @Param("subjectCode") String subjectCode,
                                                    @Param("time") Date time);
}
