package com.webexam.mapper;

import com.webexam.common.entity.Major;

import java.util.List;

/**
 * 专业mapper
 *
 * @author: zhangteng
 * @time: 14-1-15 下午5:10
 */
public interface MajorMapper {

    /**
     * 查询所有专业
     *
     * @return
     */
    public List<Major> queryAll();
}
