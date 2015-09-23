package com.webexam.service.impl;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.webexam.common.entity.WebLesson;
import com.webexam.common.exception.WebexamException;
import com.webexam.common.service.impl.BaseServiceImpl;
import com.webexam.mapper.WebLessonMapper;
import com.webexam.service.WebLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * WebLessonServiceImpl
 *
 * @author: zhangteng
 * @time: 14-2-11 下午4:54
 */
@Service("webLessonService")
public class WebLessonServiceImpl extends BaseServiceImpl implements WebLessonService {

    @Autowired
    private WebLessonMapper webLessonMapper;

    @Override
    public List<WebLesson> queryAll() throws SSException {
        try {
            return webLessonMapper.queryAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.QueryFail);
        }
    }
}
