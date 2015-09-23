package com.webexam.mapper;

import com.webexam.common.entity.WebLesson;

import java.util.List;

/**
 * WebLessonMapper
 *
 * @author: zhangteng
 * @time: 14-2-11 下午4:57
 */
public interface WebLessonMapper {

    /**
     * 查询全部
     *
     * @return
     */
    public List<WebLesson> queryAll();
}
