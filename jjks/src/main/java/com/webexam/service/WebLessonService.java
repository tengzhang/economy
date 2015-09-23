package com.webexam.service;


import com.pandawork.core.exception.SSException;
import com.webexam.common.entity.WebLesson;
import com.webexam.common.service.BaseService;

import java.util.List;

/**
 * WebLessonService
 *
 * @author: zhangteng
 * @time: 14-2-11 下午4:53
 */
public interface WebLessonService extends BaseService {

    /**
     * 查询全部
     *
     * @return
     * @throws SSException
     */
    public List<WebLesson> queryAll() throws SSException;
}
