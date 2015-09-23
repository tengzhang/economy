package com.webexam.service.impl;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.pandawork.core.util.CommonUtil;
import com.webexam.common.entity.Admin;
import com.webexam.common.exception.WebexamException;
import com.webexam.common.service.impl.BaseServiceImpl;
import com.webexam.mapper.AdminMapper;
import com.webexam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 管理员service实现
 *
 * @author: zhangteng
 * @time: 14-1-16 下午2:38
 */
@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) throws SSException {
        try {
            admin.setPassword(CommonUtil.md5(admin.getPassword()));
            Integer id = adminMapper.chekcLogin(admin);
            if(id != null) {
                admin.setId(id);
                return admin;
            } else {
                return null;
            }
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public boolean modifypwd(Integer id, String newPwd, String oldPwd) throws SSException {
        try {
            Admin admin = this.queryById(Admin.class, id);
            newPwd = CommonUtil.md5(newPwd);
            oldPwd = CommonUtil.md5(oldPwd);
            if(!admin.getPassword().equals(oldPwd)) {
                return false;
            }
            admin.setPassword(newPwd);
            this.update(admin);
            return true;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(WebexamException.SystemException);
        }
    }
}
