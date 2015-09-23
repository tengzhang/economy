package com.economy.mapper;

import com.economy.common.entity.IndexImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 首页图片mapper
 *
 * @author: zhangteng
 * @time: 2014/4/11 10:44
 */
public interface IndexImgMapper {

    /**
     * 查询全部
     *
     * @return
     */
    public List<IndexImg> queryAll();

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public IndexImg queryById(@Param("id") Integer id);
}
