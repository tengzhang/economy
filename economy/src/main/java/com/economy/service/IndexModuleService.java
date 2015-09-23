package com.economy.service;

import com.economy.common.entity.IndexModule;
import com.economy.common.service.BaseService;
import com.pandawork.core.exception.SSException;

import java.util.List;

/**
 * 首页版块service
 *
 * @author: zhangteng
 * @time: 2014/4/11 10:50
 */
public interface IndexModuleService extends BaseService {

    /**
     * 查询全部
     *
     * @return
     * @throws SSException
     */
    public List<IndexModule> queryAll() throws SSException;

    /**
     * 查询记录数
     *
     * @return
     * @throws SSException
     */
    public int queryCount() throws SSException;
}
