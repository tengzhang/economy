package com.economy.service;

import com.economy.common.entity.Major;
import com.economy.common.service.BaseService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;

import java.util.List;

/**
 * 专业service
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:04
 */
public interface MajorService extends BaseService {

    /**
     * 查询记录数
     *
     * @param search
     * @return
     * @throws SSException
     */
    public int queryCountByCondition(String search) throws SSException;

    /**
     * 条件查询
     *
     * @param page
     * @param search
     * @return
     * @throws SSException
     */
    public List<Major> queryByCondition(Pagination page, String search) throws SSException;

    /**
     * 查询全部
     *
     * @return
     */
    public List<Major> queryAll() throws SSException;
}
