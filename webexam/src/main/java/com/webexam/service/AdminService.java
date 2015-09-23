package com.webexam.service;

import com.pandawork.core.exception.SSException;
import com.webexam.common.entity.Admin;
import com.webexam.common.service.BaseService;

/**
 * 管理员srvice接口
 *
 * @author: zhangteng
 * @time: 14-1-16 下午2:37
 */
public interface AdminService extends BaseService {

    /**
     * 登陆
     * 如果成功，返回userid，如果失败，返回0
     * @return
     * @throws SSException
     */
    public Admin login(Admin admin) throws SSException;

    /**
     * 修改密码
     *
     * @param newPwd
     * @param oldPwd
     * @throws SSException
     */
    public boolean modifypwd(Integer adminId, String newPwd, String oldPwd) throws SSException;
}
