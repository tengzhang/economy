package com.webexam.mapper;

import com.webexam.common.entity.Subject;

import java.util.List;
import java.util.Map;

/**
 * SubjectMapper
 *
 * @author: zhangteng
 * @time: 14-1-21 下午2:08
 */
public interface SubjectMapper {

    /**
     * 查询全部
     *
     * @return
     */
    public List<Subject> queryAll();

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    public List<Subject> queryByPage(Map<String, Object> params);
}
