package com.webexam.service;

import com.pandawork.core.exception.SSException;
import com.webexam.common.entity.Major;
import com.webexam.common.service.BaseService;

import java.util.List;

/**
 * 专业相关service
 *
 * @author: zhangteng
 * @time: 14-1-15 下午5:00
 */
public interface MajorService extends BaseService {


    /**
     * 查询所有专业
     *
     * @return
     * @throws SSException
     */
    public List<Major> queryAll() throws SSException;
}
