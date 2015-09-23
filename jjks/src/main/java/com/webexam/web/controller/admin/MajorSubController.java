package com.webexam.web.controller.admin;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import com.webexam.common.dto.MajorSubjectDto;
import com.webexam.common.entity.Major;
import com.webexam.common.entity.MajorSubject;
import com.webexam.common.entity.Subject;
import com.webexam.common.utils.WebConstants;
import com.webexam.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * MajorSubController
 *
 * @author: zhangteng
 * @time: 14-1-24 下午11:05
 */
@Controller
@RequestMapping(value = "admin/major/subject")
public class MajorSubController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("basicMenuActived", true);
        model.addAttribute("majorSubMenuActived", true);
    }

    /**
     * 去专业列表页面
     *
     * @param pageNo
     * @param model
     * @return
     */
    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String getList(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                          Model model) {
        try {
            if(pageNo == null) {
                pageNo = 1;
            }
            int dataCount = majorSubjectService.queryCount();
            Pagination page = new Pagination(dataCount, pageSize, pageNo);
            List<MajorSubjectDto> list = majorSubjectService.queryByPage(page);
            model.addAttribute("list", list);
            model.addAttribute("page", page);
            return "admin/majorSubject/list";
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
            List<Major> majorList = majorService.queryAll();
            List<Subject> subjectList = subjectService.queryAll();
            model.addAttribute("majorList", majorList);
            model.addAttribute("subjectList", subjectList);
            return "admin/majorSubject/insert";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(@RequestParam Integer majorId,
                         @RequestParam List<Integer> subjectIds) {
        try {
            List<MajorSubject> majorSubjectList = new ArrayList<MajorSubject>();
            for(Integer sId : subjectIds) {
                MajorSubject majorSubject = new MajorSubject();
                majorSubject.setMajorId(majorId);
                majorSubject.setSubjectId(sId);
                majorSubjectList.add(majorSubject);
            }
            majorSubjectService.insertAll(majorSubjectList);
            return "redirect:/admin/major/subject";
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
            MajorSubject majorSubject = majorSubjectService.queryById(MajorSubject.class, id);
            List<Major> majorList = majorService.queryAll();
            List<Subject> subjectList = subjectService.queryAll();
            model.addAttribute("majorSubject", majorSubject);
            model.addAttribute("majorList", majorList);
            model.addAttribute("subjectList", subjectList);
            return "admin/majorSubject/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(MajorSubject majorSubject) {
        try {
            majorSubjectService.update(majorSubject);
            return "redirect:/admin/major/subject";
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
            MajorSubject majorSubject = majorSubjectService.queryById(MajorSubject.class, id);
            majorSubjectService.delete(majorSubject);
            return "redirect:/admin/major/subject";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
