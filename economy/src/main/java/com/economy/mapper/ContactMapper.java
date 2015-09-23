package com.economy.mapper;

import com.economy.common.entity.Contact;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ContactMapper
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:32
 */
public interface ContactMapper {

    /**
     * 查询全部
     *
     * @return
     */
    public List<Contact> queryAll();

    /**
     * 根据首页模块查询
     *
     * @param indexModuleId
     * @return
     */
    public List<Contact> queryByIndexModuleId(@Param("indexModuleId") Integer indexModuleId);
}
