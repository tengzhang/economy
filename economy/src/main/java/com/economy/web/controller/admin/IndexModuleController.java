package com.economy.web.controller.admin;

import com.economy.common.entity.IndexModule;
import com.economy.common.utils.WebConstants;
import com.economy.web.spring.AbstractController;
import com.pandawork.core.exception.SSException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * IndexModuleController
 *
 * @author: zhangteng
 * @time: 2014/4/11 17:34
 */
@Controller
@RequestMapping("admin/index/module")
public class IndexModuleController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("indexModuleMenuActived", true);
    }

    /**
     * 去首页模块管理页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String list(Model model) {
        try {
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
            return "admin/index/module/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 添加
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(Model model) {
        try {
            int sortNo = indexModuleService.queryCount() + 1;
            model.addAttribute("sortNo", sortNo);
            return "admin/index/module/insert";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(IndexModule indexModule) {
        try {
            indexImgService.insert(indexModule);
            return "redirect:/admin/index/module";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 更新
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,
                           Model model) {
        try {
            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, id);
            model.addAttribute("indexModule", indexModule);
            return "admin/index/module/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(IndexModule indexModule) {
        try {
            indexModuleService.update(indexModule);
            return "redirect:/admin/index/module";
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
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        try {
            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, id);
            indexModuleService.delete(indexModule);
            return "redirect:/admin/index/module";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
