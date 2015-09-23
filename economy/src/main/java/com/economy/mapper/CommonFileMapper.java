package com.economy.mapper;

import com.economy.common.entity.CommonFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * CommonFileMapper
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:37
 */
public interface CommonFileMapper {

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
    public List<CommonFile> queryByCondition(Map<String, Object> params);
}
