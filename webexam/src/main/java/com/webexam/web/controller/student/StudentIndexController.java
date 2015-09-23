package com.webexam.web.controller.student;

import com.pandawork.core.exception.SSException;
import com.webexam.common.dto.ExamAnswerListForm;
import com.webexam.common.dto.StudentDto;
import com.webexam.common.entity.*;
import com.webexam.common.utils.WebConstants;
import com.webexam.web.spring.AbstractController;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * StudentIndexController
 *
 * @author: zhangteng
 * @time: 14-2-5 下午12:43
 */
@Controller
@RequestMapping(value = "student")
public class StudentIndexController extends AbstractController {

    /**
     * 去首页
     *
     * @return
     */
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index() {
        try {
            getRequest().getSession().setAttribute("lessonUrl", webLessonService.queryAll().get(0).getLessonUrl());
            return "student/index";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.studentSysErrorCode;
        }
    }

    /**
     * 登陆
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin(Model model) {
        try {
            List<Major> majorList = majorService.queryAll();
            model.addAttribute("majorList", majorList);
            return "student/login";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.studentSysErrorCode;
        }
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String examNo,
                        String name,
                        String majorCode,
                        Model model) {
        try {
            Student student = studentService.login(examNo, name, majorCode);
            if(student != null) {
                getRequest().getSession().setAttribute(WebConstants.STUSESSIONUID, student.getId());
                //getRequest().getSession().setAttribute("student", student);
                return "student/index";
            } else {
                model.addAttribute("msg", "准考证号或姓名错误!");
                List<Major> majorList = majorService.queryAll();
                model.addAttribute("majorList", majorList);
                return "student/login";
            }
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.studentSysErrorCode;
        }
    }

    /**
     * 退出
     *
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        try {
            // getRequest().getSession().setAttribute(WebConstants.STUSESSIONUID, null);
            getRequest().getSession().invalidate();
            return "redirect:/student/login";
        } catch (Exception e) {
            sendErrMsg(e.getMessage());
            return WebConstants.studentSysErrorCode;
        }
    }
    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(Model model) {
        try {
            Integer uid = (Integer) getRequest().getSession().getAttribute(WebConstants.STUSESSIONUID);
            StudentDto studentDto = studentService.queryDtoById(uid);
            model.addAttribute("studentDto", studentDto);
            return "student/info";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.studentSysErrorCode;
        }
    }

    /**
     * 选择考试页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "exam/choose", method = RequestMethod.GET)
    public String chooseExam(Model model) {
        try {
            Integer id = (Integer) getRequest().getSession().getAttribute(WebConstants.STUSESSIONUID);
            Student student = studentService.queryById(Student.class, id);
            List<WebExam> examList = studentService.queryExamById(id);
            model.addAttribute("student", student);
            model.addAttribute("examList", examList);
            return "student/chooseExam";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.studentSysErrorCode;
        }
    }

    /**
     * 考前注意事项页面
     *
     * @param majorCode
     * @param subjectCode
     * @param model
     * @return
     */
    @RequestMapping(value = "exam/pre/{majorCode}/{subCode}", method = RequestMethod.GET)
    public String preExam(@PathVariable("majorCode") String majorCode,
                          @PathVariable("subCode") String subjectCode,
                          Model model) {
        model.addAttribute("majorCode", majorCode);
        model.addAttribute("subjectCode", subjectCode);
        return "student/preExam";
    }

    /**
     * 考试页面
     *
     * @param majorCode
     * @param subCode
     * @param model
     * @return
     */
    @RequestMapping(value = "exam/{majorCode}/{subCode}", method = RequestMethod.GET)
    public String exam(@PathVariable("majorCode") String majorCode,
                       @PathVariable("subCode") String subCode,
                       Model model) {
        try {
            List<Problem> problemList = problemService.getRandomProblems(majorCode, subCode);
            WebExam webExam = webExamService.queryExamByMajorAndSubject(majorCode, subCode);
            Integer sid = (Integer) getRequest().getSession().getAttribute(WebConstants.STUSESSIONUID);
            Student student = studentService.queryById(Student.class, sid);
            model.addAttribute("problemList", problemList);
            model.addAttribute("webExam", webExam);
            model.addAttribute("student", student);
            return "student/exam";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.studentSysErrorCode;
        }
    }

    /**
     * 试卷提交页面
     *
     * @param listForm
     * @param model
     * @param majorCode
     * @param subCode
     * @return
     */
    @RequestMapping(value = "result/{majorCode}/{subCode}", method = RequestMethod.POST)
    public String result(ExamAnswerListForm listForm,
                         Model model,
                         @PathVariable("majorCode") String majorCode,
                         @PathVariable("subCode") String subCode) {
        try {
            List<Integer> ids = listForm.getIds();
            List<String[]> answers = listForm.getAnswers();
            Integer sid = (Integer) getRequest().getSession().getAttribute(WebConstants.STUSESSIONUID);
            studentService.calculateScore(sid, ids, answers, majorCode, subCode);

            WebExam webExam = webExamService.queryExamByMajorAndSubject(majorCode, subCode);
            Student student = studentService.queryById(Student.class, sid);
            model.addAttribute("webExam", webExam);
            model.addAttribute("student", student);
            return "student/result";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.studentSysErrorCode;
        }
    }

    @RequestMapping(value = "404", method = RequestMethod.GET)
    public String to404() {
        return "student/404";
    }

    @RequestMapping(value = "500", method = RequestMethod.GET)
    public String to500() {
        return "student/500";
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String toTest() {
        return "student/test";
    }

}
