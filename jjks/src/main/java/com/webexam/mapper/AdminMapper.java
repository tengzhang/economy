package com.webexam.mapper;

import com.webexam.common.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * AdminMapper
 *
 * @author: zhangteng
 * @time: 14-1-16 下午4:46
 */
public interface AdminMapper {

    /**
     * 判断是否能登陆
     *
     * @param admin
     * @return
     */
    public Integer chekcLogin(@Param("admin") Admin admin);
}
