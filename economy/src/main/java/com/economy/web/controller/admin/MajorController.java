package com.economy.web.controller.admin;

import com.economy.common.entity.IndexModule;
import com.economy.common.entity.Major;
import com.economy.common.utils.WebConstants;
import com.economy.web.spring.AbstractController;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * MajorController
 *
 * @author: zhangteng
 * @time: 2014/4/29 14:25
 */
@Controller
@RequestMapping("admin/major")
public class MajorController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("majorMenuActived", true);
    }

    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String list(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                       @RequestParam(value = "search", required = false) String search,
                       Model model) {
        try {
            if(pageNo == null) {
                pageNo = 1;
            }
            if(search == null || search.equals("") || search.length()==0) {
                search = null;
            }
            int dataCount = majorService.queryCountByCondition(search);
            Pagination page = new Pagination(dataCount, this.pageSize, pageNo);
            List<Major> majorList = majorService.queryByCondition(page, search);

            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("majorList", majorList);
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("page", page);
            model.addAttribute("search", search);
            return "admin/major/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(Model model) {
        try {
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
            return "admin/major/insert";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Major major) {
        try {
            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, major.getIndexModuleId());
            major.setIndexModuleName(indexModule.getName());
            majorService.insert(major);
            return "redirect:/admin/major";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,
                           Model model) {
        try {
            Major major = majorService.queryById(Major.class, id);
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
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
            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, major.getIndexModuleId());
            major.setIndexModuleName(indexModule.getName());
            majorService.update(major);
            return "redirect:/admin/major";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        try {
            Major major = majorService.queryById(Major.class, id);
            majorService.delete(major);
            return "redirect:/admin/major";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
