package com.economy.service;

import com.economy.common.entity.Contact;
import com.economy.common.service.BaseService;
import com.pandawork.core.exception.SSException;

import java.util.List;

/**
 * 联系我们Service
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:33
 */
public interface ContactService extends BaseService {

    /**
     * 查询全部
     *
     * @return
     */
    public List<Contact> queryAll() throws SSException;

    /**
     * 根据首页模块查询
     *
     * @param indexModuleId
     * @return
     * @throws SSException
     */
    public Contact queryByIndexModuleId(Integer indexModuleId) throws SSException;
}
