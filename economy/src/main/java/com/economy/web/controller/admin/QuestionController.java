package com.economy.web.controller.admin;

import com.economy.common.entity.IndexModule;
import com.economy.common.entity.Question;
import com.economy.common.utils.WebConstants;
import com.economy.web.spring.AbstractController;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * QuestionController
 *
 * @author: zhangteng
 * @time: 2014/4/11 17:35
 */
@Controller
@RequestMapping("admin/question")
public class QuestionController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("questionMenuActived", true);
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
            int dataCount = questionService.queryCountByCondition(search);
            Pagination page = new Pagination(dataCount, this.pageSize, pageNo);
            List<Question> questionList = questionService.queryByCondition(page, search);

            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("questionList", questionList);
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("page", page);
            model.addAttribute("search", search);
            return "admin/question/list";
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
            return "admin/question/insert";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Question question) {
        try {
            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, question.getIndexModuleId());
            question.setIndexModuleName(indexModule.getName());
            question.setPublicTime(new Date());
            questionService.insert(question);
            return "redirect:/admin/question";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,
                           Model model) {
        try {
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);

            Question question = questionService.queryById(Question.class, id);
            model.addAttribute("question", question);
            return "admin/question/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Question question) {
        try {
            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, question.getIndexModuleId());
            question.setIndexModuleName(indexModule.getName());
            question.setPublicTime(new Date());
            questionService.update(question);
            return "redirect:/admin/question";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Integer id,
                       Model model) {
        try {
            Question question = questionService.queryById(Question.class, id);
            model.addAttribute("question", question);
            return "admin/question/view";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        try {
            Question question = questionService.queryById(Question.class, id);
            questionService.delete(question);
            return "redirect:/admin/question";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "batch/delete", method = RequestMethod.POST)
    public @ResponseBody
    JSONObject batchDel(@RequestParam String ids) {
        try {
            String[] idsStr = ids.split(",");
            for(String id : idsStr) {
                if(id != null && !("").equals(id)) {
                    Question question = questionService.queryById(Question.class, Integer.parseInt(id));
                    questionService.delete(question);
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
