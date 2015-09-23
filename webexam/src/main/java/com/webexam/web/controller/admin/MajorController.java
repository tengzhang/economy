package com.webexam.web.controller.admin;

import com.pandawork.core.exception.SSException;
import com.webexam.common.entity.Major;
import com.webexam.common.utils.WebConstants;
import com.webexam.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * MajorController
 *
 * @author: zhangteng
 * @time: 14-1-17 上午11:07
 */
@Controller
@RequestMapping(value = "admin/major")
public class MajorController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("basicMenuActived", true);
        model.addAttribute("majorMenuActived", true);
    }

    /**
     * 去专业列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String list(Model model) {
        try {
            List<Major> majorList = majorService.queryAll();
            model.addAttribute("majorList", majorList);
            return "admin/major/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 添加
     *
     * @return
     */
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert() {
        return "admin/major/insert";
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Major major) {
        try {
            majorService.insert(major);
            return "redirect:/admin/major";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 根据id修改
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,
                              Model model) {
        try {
            Major major = majorService.queryById(Major.class, id);
            model.addAttribute("major", major);
            return "admin/major/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Major major) {
        try {
            majorService.update(major);
            return "redirect:/admin/major";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String del(@PathVariable("id") Integer id) {
        try {
            Major major = new Major();
            major.setId(id);
            majorService.delete(major);
            return "redirect:/admin/major";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
