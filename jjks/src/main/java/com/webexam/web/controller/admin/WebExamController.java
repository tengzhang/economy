package com.webexam.web.controller.admin;

import com.pandawork.core.excel.ExcelReader;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import com.webexam.common.entity.Major;
import com.webexam.common.entity.Subject;
import com.webexam.common.entity.WebExam;
import com.webexam.common.utils.WebConstants;
import com.webexam.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * WebexamController
 *
 * @author: zhangteng
 * @time: 14-2-2 下午9:55
 */
@RequestMapping(value = "admin/webExam")
@Controller
public class WebExamController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("webExamMenuActived", true);
    }

    /**
     * 去网络测试管理页面
     *
     * @param pageNo
     * @param model
     * @return
     */
    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String list(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                       Model model) {
        try {
            if(pageNo == null) {
                pageNo = 1;
            }
            int dataCount = webExamService.queryCount();
            Pagination page = new Pagination(dataCount, pageSize, pageNo);
            List<WebExam> webExamList = webExamService.queryByPage(page);
            model.addAttribute("webExamList", webExamList);
            model.addAttribute("page", page);
            return "admin/webExam/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 搜索
     *
     * @param search
     * @param model
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(@RequestParam String search,
                         Model model) {
        try {
            List<WebExam> webExamList = webExamService.queryBySearch(search);
            model.addAttribute("webExamList", webExamList);
            model.addAttribute("search", search);
            return "admin/webExam/list";
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
            return "admin/webExam/insert";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(WebExam webExam,
                         @RequestParam Integer majorId,
                         @RequestParam Integer subjectId,
                         @RequestParam String startTime,
                         @RequestParam String endTime) {
        try {
            Major major = majorService.queryById(Major.class, majorId);
            Subject subject = subjectService.queryById(Subject.class, subjectId);
            webExam.setMajorCode(major.getCode());
            webExam.setMajorName(major.getName());
            webExam.setSubjectCode(subject.getCode());
            webExam.setSubjectName(subject.getName());

            webExamService.insert(webExam);
            return "redirect:/admin/webExam";
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
            WebExam webExam = webExamService.queryById(WebExam.class, id);
            List<Major> majorList = majorService.queryAll();
            List<Subject> subjectList = subjectService.queryAll();
            model.addAttribute("majorList", majorList);
            model.addAttribute("subjectList", subjectList);
            model.addAttribute("webExam", webExam);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            model.addAttribute("startTime", sdf.format(webExam.getStartTime()));
            model.addAttribute("endTime", sdf.format(webExam.getEndTime()));
            return "admin/webExam/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(WebExam webExam,
                         @RequestParam Integer majorId,
                         @RequestParam Integer subjectId) {
        try {
            Major major = majorService.queryById(Major.class, majorId);
            Subject subject = subjectService.queryById(Subject.class, subjectId);
            webExam.setMajorCode(major.getCode());
            webExam.setMajorName(major.getName());
            webExam.setSubjectCode(subject.getCode());
            webExam.setSubjectName(subject.getName());

            webExamService.update(webExam);
            return "redirect:/admin/webExam";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        try {
            WebExam webExam = webExamService.queryById(WebExam.class, id);
            webExamService.delete(webExam);
            return "redirect:/admin/webExam";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
