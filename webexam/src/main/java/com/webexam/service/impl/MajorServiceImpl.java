package com.webexam.service.impl;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.webexam.common.entity.Major;
import com.webexam.common.exception.WebexamException;
import com.webexam.common.service.impl.BaseServiceImpl;
import com.webexam.mapper.MajorMapper;
import com.webexam.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专业相关service实现
 *
 * @author: zhangteng
 * @time: 14-1-15 下午5:01
 */
@Service("majorService")
public class MajorServiceImpl extends BaseServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public List<Major> queryAll() throws SSException {
        try {
            return majorMapper.queryAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw SSException.get(WebexamException.QueryFail);
        }
    }
}
