package com.economy.service.impl;

import com.economy.common.entity.Major;
import com.economy.common.exception.EconomyException;
import com.economy.common.service.impl.BaseServiceImpl;
import com.economy.mapper.MajorMapper;
import com.economy.service.MajorService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.pandawork.core.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MajorServiceImpl
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:05
 */
@Service("majorService")
public class MajorServiceImpl extends BaseServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public int queryCountByCondition(String search) throws SSException {
        try {
            return majorMapper.queryCountByCondition(search);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public List<Major> queryByCondition(Pagination page, String search) throws SSException {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            int pCurrent = 0, pSize = 10;
            if(page != null) {
                pCurrent = page.getCurrentFristPosition();
                pSize = page.getPageSize();
            }
            params.put("pCurrent", pCurrent);
            params.put("pSize", pSize);
            params.put("search", search);
            List<Major> majorList = majorMapper.queryByCondition(params);
            return majorList;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public List<Major> queryAll() throws SSException {
        try {
            return majorMapper.queryAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }
}
