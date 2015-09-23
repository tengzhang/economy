package com.webexam.common.service.impl;

import com.pandawork.core.dao.CommonDao;
import com.pandawork.core.entity.AbstractEntity;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.webexam.common.exception.WebexamException;
import com.webexam.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * BaseServiceImpl
 *
 * @author: zhangteng
 * @time: 14-1-16 上午10:49
 */
public class BaseServiceImpl implements BaseService {

    @Autowired
    protected CommonDao commonDao;

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public <T extends AbstractEntity> T insert(T t) throws SSException {
        try {
            return commonDao.insert(t);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.InserFail);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public <T extends AbstractEntity> void insertAll(Collection<T> objs) throws SSException {
        try {
            commonDao.insertAll(objs);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.InserFail);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public <T extends AbstractEntity> void update(T t) throws SSException {
        try {
            commonDao.update(t);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.UpdateFail);
        }
    }

    @Override
    public <T extends AbstractEntity> void delete(T t) throws SSException {
        try {
            commonDao.delete(t);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.DeleteFail);
        }
    }

    @Override
    public <T extends AbstractEntity> T queryById(Class clazz, Integer id) throws SSException {
        try {
            return (T) commonDao.queryById(clazz, id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }
}
