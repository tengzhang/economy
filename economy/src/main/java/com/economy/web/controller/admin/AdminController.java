package com.economy.web.controller.admin;

import com.economy.common.entity.Admin;
import com.economy.common.utils.WebConstants;
import com.economy.web.spring.AbstractController;
import com.pandawork.core.exception.SSException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * AdminController
 *
 * @author: zhangteng
 * @time: 14-3-30 下午8:12
 */
@Controller
@RequestMapping("admin")
public class AdminController extends AbstractController {

    /**
     * 进入管理员首页
     *
     * @return
     */
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index() {
        return "admin/index";
    }

    /**
     * 登陆
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin() {
        return "admin/login";
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Admin admin, Model model) {
        try {
            admin = adminService.login(admin);
            if(admin != null) {
                getRequest().getSession().setAttribute(WebConstants.SESSIONUID, admin.getId());
                getRequest().getSession().setAttribute("admin", admin);
                return "admin/index";
            } else {
                model.addAttribute("msg", "用户名或密码错误!");
                return "admin/login";
            }
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 退出登陆
     *
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        try {
            //getRequest().getSession().setAttribute(WebConstants.SESSIONUID, null);
            getRequest().getSession().invalidate();
            return "redirect:/admin/login";
        } catch (Exception e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }


    /**
     * 修改密码
     *
     * @return
     */
    @RequestMapping(value = "modifypwd", method = RequestMethod.GET)
    public String toModifypwd() {
        return "admin/modifypwd";
    }
    @RequestMapping(value = "modifypwd", method = RequestMethod.POST)
    public String modifypwd(@RequestParam String newPwd,
                            @RequestParam String oldPwd,
                            Model model) {
        try {
            Integer adminId = (Integer) getRequest().getSession().getAttribute(WebConstants.SESSIONUID);
            if(adminService.modifypwd(adminId, newPwd, oldPwd)) {
                model.addAttribute("msgCode", 1);
                model.addAttribute("msg", "密码修改成功!");
                return "admin/modifypwd";
            } else {
                model.addAttribute("msgCode", 0);
                model.addAttribute("msg", "旧密码错误!");
                return "admin/modifypwd";
            }
        } catch (Exception e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
