package com.economy.web.controller.index;

import com.economy.common.entity.Article;
import com.economy.common.entity.Attachment;
import com.economy.common.entity.IndexModule;
import com.economy.common.enums.ArticleTypeEnum;
import com.economy.common.utils.WebConstants;
import com.economy.web.spring.AbstractController;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * IndexSubjectController
 *
 * @author: zhangteng
 * @time: 2014/5/2 11:03
 */
@Controller
@RequestMapping("index")
public class IndexSubjectController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        try {
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("subjectActive", true);
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
        }
    }

    @RequestMapping(value = "subjects/{indexModuleId}", method = RequestMethod.GET)
    public String list(@PathVariable("indexModuleId") Integer indexModuleId,
                       Model model) {
        try {
            int dataCount = articleService.queryCountByCondition(ArticleTypeEnum.Subject.getType(), indexModuleId.toString());
            Pagination page = new Pagination(dataCount, this.pageSize, 1);
            List<Article> subjectList = articleService.queryByCondition(page, indexModuleId.toString(), ArticleTypeEnum.Subject.getType());

            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, indexModuleId);

            model.addAttribute("subjectList", subjectList);
            model.addAttribute("indexModule", indexModule);
            model.addAttribute("page", page);

            return "index/subject/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "subject/{indexModuleId}/{subjectId}", method = RequestMethod.GET)
    public String view(@PathVariable("indexModuleId") Integer indexModuleId,
                       @PathVariable("subjectId") Integer subjectId,
                       Model model) {
        try {
            Article subject = articleService.queryById(Article.class, subjectId);
            if(subject.getHasAttachment() == 1) {
                List<Attachment> attachmentList = attachmentService.queryByArticleId(subjectId);
                model.addAttribute("attachmentList", attachmentList);
            }
            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, indexModuleId);

            model.addAttribute("subject", subject);
            model.addAttribute("indexModule", indexModule);

            return "index/subject/view";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
