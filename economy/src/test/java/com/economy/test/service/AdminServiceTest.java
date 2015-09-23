package com.economy.test.service;

import com.economy.common.entity.Admin;
import com.economy.service.AdminService;
import com.economy.test.AbstractTestCase;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.CommonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AdminServiceTest
 *
 * @author: zhangteng
 * @time: 14-3-30 下午8:17
 */
public class AdminServiceTest extends AbstractTestCase {

    @Autowired
    private AdminService adminService;

    @Test
    public void insert() throws SSException {
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword(CommonUtil.md5("admin"));
        adminService.insert(admin);
    }
}
