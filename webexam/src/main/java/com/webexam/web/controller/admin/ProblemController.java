package com.webexam.web.controller.admin;

import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import com.pandawork.core.web.spring.fileupload.PandaworkMultipartFile;
import com.webexam.common.dto.MajorSubjectDto;
import com.webexam.common.entity.Major;
import com.webexam.common.entity.Problem;
import com.webexam.common.entity.Subject;
import com.webexam.common.exception.WebexamException;
import com.webexam.common.utils.WebConstants;
import com.webexam.web.spring.AbstractController;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ProblemController
 *
 * @author: zhangteng
 * @time: 14-2-5 下午11:49
 */
@Controller
@RequestMapping(value = "admin/problem")
public class ProblemController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("basicMenuActived", true);
        model.addAttribute("problemMenuActived", true);
    }

    /**
     * 去题目列表页面
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
            int dataCount = problemService.queryCount();
            Pagination page = new Pagination(dataCount, pageSize, pageNo);
            List<Problem> problemList = problemService.queryByPage(page);
            model.addAttribute("problemList", problemList);
            model.addAttribute("page", page);
            return "admin/problem/list";
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
            return "admin/problem/insert";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Problem problem,
                         Integer majorId,
                         Integer subjectId) {
        try {
            Major major = majorService.queryById(Major.class, majorId);
            Subject subject = subjectService.queryById(Subject.class, subjectId);
            problem.setMajorCode(major.getCode());
            problem.setMajorName(major.getName());
            problem.setSubjectCode(subject.getCode());
            problem.setSubjectName(subject.getName());

            problemService.insertProblem(problem);
            return "redirect:/admin/problem";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 批量添加
     *
     * @return
     */
    @RequestMapping(value = "batch/insert", method = RequestMethod.GET)
    public String toBatchInsert() {
        return "admin/problem/batchInsert";
    }
    @RequestMapping(value = "batch/insert", method = RequestMethod.POST)
    public String batchInsert(@RequestParam("problemFile")PandaworkMultipartFile problemFile,
                              Model model) {
        try {
            if(problemFile.isEmpty()) {
                model.addAttribute("msgCode", WebexamException.FileNotNull.getCode());
                model.addAttribute("msg", WebexamException.FileNotNull.getMes());
            } else {
                String filename = problemFile.getOriginalFilename();
                if(!filename.substring(filename.lastIndexOf(".") + 1).equalsIgnoreCase("xls")) {
                    model.addAttribute("msgCode", WebexamException.FileNotXls);
                    model.addAttribute("msg", WebexamException.FileNotXls.getMes());
                } else {
                    problemService.batchInsert(problemFile.getFile());
                    model.addAttribute("msgCode", 0);
                    model.addAttribute("msg", "添加成功！");
                }
            }
            return "admin/problem/batchInsert";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    /**
     * 批量导出
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "batch/toExport", method = RequestMethod.GET)
    public String toBatchExport(Model model) {
        try {
            List<Problem> majorSubjectList = problemService.queryDistinctProblem();
            model.addAttribute("majorSubjectList", majorSubjectList);
            return "admin/problem/batchExport";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "batch/export", method = RequestMethod.GET)
    public void batchExport(@RequestParam String majorCode,
                            @RequestParam String subjectCode) {
        try {
            problemService.batchExportByMajorAndSubject(majorCode, subjectCode, getResponse());
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
        }
    }

    /**
     * 查看题目详情
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Integer id,
                       Model model) {
        try {
            Problem problem = problemService.queryById(Problem.class, id);
            model.addAttribute("problem", problem);
            return "admin/problem/detail";
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
            List<Major> majorList = majorService.queryAll();
            List<Subject> subjectList = subjectService.queryAll();
            Problem problem = problemService.queryById(Problem.class, id);
            model.addAttribute("majorList", majorList);
            model.addAttribute("subjectList", subjectList);
            model.addAttribute("problem", problem);
            return "admin/problem/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Problem problem,
                         Integer majorId,
                         Integer subjectId) {
        try {
            Major major = majorService.queryById(Major.class, majorId);
            Subject subject = subjectService.queryById(Subject.class, subjectId);
            problem.setMajorCode(major.getCode());
            problem.setMajorName(major.getName());
            problem.setSubjectCode(subject.getCode());
            problem.setSubjectName(subject.getName());

            problemService.updateProblem(problem);
            return "redirect:/admin/problem";
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
            problemService.deleteById(id);
            return "redirect:/admin/problem";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "batch/del", method = RequestMethod.POST)
    public @ResponseBody JSONObject batchDel(@RequestParam String ids) {
        try {
            String[] idsStr = ids.split(",");
            for(String id : idsStr) {
                if(id != null && !("").equals(id)) {
                    problemService.deleteById(Integer.parseInt(id));
                }
            }
            JSONObject json = new JSONObject();
            json.put("code", 0);
            return json;
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return sendErrMsgAndErrCode(e);
        }
    }
}
