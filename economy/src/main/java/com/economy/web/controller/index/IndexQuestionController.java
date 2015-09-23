package com.economy.web.controller.index;

import com.economy.common.entity.IndexModule;
import com.economy.common.entity.Question;
import com.economy.common.utils.WebConstants;
import com.economy.web.spring.AbstractController;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * IndexQuestionController
 *
 * @author: zhangteng
 * @time: 2014/5/3 14:51
 */
@Controller
@RequestMapping("index")
public class IndexQuestionController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        try {
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("questionActive", true);
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
        }
    }

    @RequestMapping(value = "questions/{indexModuleId}", method = RequestMethod.GET)
    public String list(@PathVariable("indexModuleId") Integer indexModuleId,
                       @RequestParam(value = "pageNo", required = false) Integer pageNo,
                       Model model) {
        try {
            if(pageNo == null) {
                pageNo = 1;
            }
            int dataCount = questionService.queryCountByCondition(indexModuleId.toString());
            Pagination page = new Pagination(dataCount, this.pageSize, pageNo);
            List<Question> questionList = questionService.queryByCondition(page, indexModuleId.toString());

            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, indexModuleId);

            model.addAttribute("questionList", questionList);
            model.addAttribute("indexModule", indexModule);
            model.addAttribute("page", page);

            return "index/question/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
