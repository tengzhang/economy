package com.economy.mapper;

import com.economy.common.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 常见问题mapper
 *
 * @author: zhangteng
 * @time: 2014/4/11 10:44
 */
public interface QuestionMapper {

    /**
     * 查询问题条数
     *
     * @return
     */
    public int queryCountByCondition(@Param("search") String search);

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    public List<Question> queryByPage(Map<String, Object> params);

    /**
     * 条件查询
     *
     * @param params
     * @return
     */
    public List<Question> queryByCondition(Map<String, Object> params);
}
