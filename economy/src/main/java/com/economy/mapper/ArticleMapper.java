package com.economy.mapper;

import com.economy.common.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * ArticleMapper
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:21
 */
public interface ArticleMapper {

    /**
     * 根据类型查询记录数
     *
     * @param type
     * @return
     */
    public int queryCountByCondition(@Param("type") Integer type,
                                     @Param("search") String search);

    /**
     * 条件查询
     *
     * @param params
     * @return
     */
    public List<Article> queryByCondition(Map<String, Object> params);
}
