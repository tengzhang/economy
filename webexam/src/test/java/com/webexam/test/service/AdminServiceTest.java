package com.webexam.test.service;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.CommonUtil;
import com.webexam.common.entity.Admin;
import com.webexam.service.AdminService;
import com.webexam.test.AbstractTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AdminServiceTest
 *
 * @author: zhangteng
 * @time: 14-1-16 下午5:31
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
