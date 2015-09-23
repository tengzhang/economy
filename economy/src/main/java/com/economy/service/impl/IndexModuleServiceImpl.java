package com.economy.service.impl;

import com.economy.common.entity.IndexModule;
import com.economy.common.exception.EconomyException;
import com.economy.common.service.impl.BaseServiceImpl;
import com.economy.mapper.IndexModuleMapper;
import com.economy.service.IndexModuleService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页版块service实现
 *
 * @author: zhangteng
 * @time: 2014/4/11 10:50
 */
@Service("indexModuleService")
public class IndexModuleServiceImpl extends BaseServiceImpl implements IndexModuleService {

    @Autowired
    private IndexModuleMapper indexModuleMapper;

    @Override
    public List<IndexModule> queryAll() throws SSException {
        try {
            return indexModuleMapper.queryAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public int queryCount() throws SSException {
        try {
            return commonDao.queryCount(IndexModule.class);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }
}
