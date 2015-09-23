package com.webexam.common.service;

import com.pandawork.core.entity.AbstractEntity;
import com.pandawork.core.exception.SSException;

import java.util.Collection;
import java.util.Collections;

/**
 * BaseService
 *
 * @author: zhangteng
 * @time: 14-1-16 上午10:47
 */
public interface BaseService {

    /**
     * 插入一条记录
     *
     * @param t
     * @param <T>
     * @return
     * @throws SSException
     */
    public <T extends AbstractEntity> T insert(T t) throws SSException;

    /**
     * 批量添加
     *
     * @param <T>
     * @throws SSException
     */
    public <T extends AbstractEntity> void insertAll(Collection<T> objs) throws SSException;
    /**
     * 更新一条记录
     *
     * @param t
     * @param <T>
     * @throws SSException
     */
    public <T extends AbstractEntity> void update(T t) throws SSException;

    /**
     * 删除一条记录
     *
     * @param t
     * @param <T>
     * @throws SSException
     */
    public <T extends AbstractEntity> void delete(T t) throws SSException;

    /**
     * 根据id进行查询
     *
     * @param clazz
     * @param id
     * @param <T>
     * @return
     * @throws SSException
     */
    public <T extends AbstractEntity> T queryById(Class clazz, Integer id) throws SSException;
}
