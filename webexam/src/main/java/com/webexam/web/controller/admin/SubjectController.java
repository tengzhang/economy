package com.webexam.web.controller.admin;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import com.webexam.common.entity.Subject;
import com.webexam.common.utils.WebConstants;
import com.webexam.web.spring.AbstractController;
import org.apache.regexp.recompile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SubjectController
 *
 * @author: zhangteng
 * @time: 14-1-21 下午1:44
 */
@Controller
@RequestMapping(value = "admin/subject")
public class SubjectController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("basicMenuActived", true);
        model.addAttribute("subjectMenuActived", true);
    }

    /**
     * 去科目列表页面
     *
     * @return
     */
    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String list(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                       Model model) {
        try {
            if(pageNo == null) {
                pageNo = 1;
            }
            int dataCount = subjectService.queryCount();
            Pagination page = new Pagination(dataCount, pageSize, pageNo);
            List<Subject> subjectList = subjectService.queryByPage(page);
            model.addAttribute("subjectList", subjectList);
            model.addAttribute("page", page);
            return "admin/subject/list";
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
        return "admin/subject/insert";
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Subject subject) {
        try {
            subjectService.insert(subject);
            return "redirect:/admin/subject";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 根据id进行修改
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,
                           Model model) {
        try {
            Subject subject = subjectService.queryById(Subject.class, id);
            model.addAttribute("subject", subject);
            return "admin/subject/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Subject subject) {
        try {
            subjectService.update(subject);
            return "redirect:/admin/subject";
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
    public String delete(@PathVariable("id") Integer id) {
        try {
            Subject subject = subjectService.queryById(Subject.class, id);
            subjectService.delete(subject);
            return "redirect:/admin/subject";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
