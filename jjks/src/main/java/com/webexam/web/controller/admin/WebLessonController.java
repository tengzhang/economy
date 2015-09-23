package com.webexam.web.controller.admin;

import com.pandawork.core.exception.SSException;
import com.webexam.common.entity.WebLesson;
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
 * WebLessonController
 *
 * @author: zhangteng
 * @time: 14-2-11 下午4:54
 */
@Controller
@RequestMapping(value = "admin/webLesson")
public class WebLessonController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("webLessonMenuActived", true);
    }

    /**
     * 去列表页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String list(Model model) {
        try {
            List<WebLesson> webLessonList = webLessonService.queryAll();
            model.addAttribute("webLessonList", webLessonList);
            return "admin/webLesson/list";
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
        return "admin/webLesson/insert";
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(WebLesson webLesson) {
        try {
            String url = webLesson.getLessonUrl();
            if(url.indexOf("http://") == -1) {
                url = "http://" + url;
            }
            webLesson.setLessonUrl(url);
            webLessonService.insert(webLesson);
            return "redirect:/admin/webLesson";
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
    public String toUpdate(@PathVariable("id") Integer id,Model model) {
        try {
            WebLesson webLesson = webLessonService.queryById(WebLesson.class, id);
            model.addAttribute("webLesson", webLesson);
            return "admin/webLesson/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(WebLesson webLesson) {
        try {
            String url = webLesson.getLessonUrl();
            if(url.indexOf("http://") == -1) {
                url = "http://" + url;
            }
            webLesson.setLessonUrl(url);
            webExamService.update(webLesson);
            return "redirect:/admin/webLesson";
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
            WebLesson webLesson = webLessonService.queryById(WebLesson.class, id);
            webLessonService.delete(webLesson);
            return "redirect:/admin/webLesson";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
