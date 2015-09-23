package com.economy.mapper;

import com.economy.common.entity.Major;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * MajorMapper
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:05
 */
public interface MajorMapper {

    /**
     * 根据条件查询记录数
     *
     * @param search
     * @return
     */
    public int queryCountByCondition(@Param("search") String search);

    /**
     * 条件查询
     *
     * @param params
     * @return
     */
    public List<Major> queryByCondition(Map<String, Object> params);

    /**
     * 查询全部
     *
     * @return
     */
    public List<Major> queryAll();
}
