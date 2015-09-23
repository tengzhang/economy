package com.economy.web.controller.admin;

import com.economy.common.dto.ArticleDto;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CooperationController
 *
 * @author: zhangteng
 * @time: 2014/4/30 14:42
 */
@Controller
@RequestMapping("admin/cooperation")
public class CooperationController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("cooperationMenuActived", true);
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
            int dataCount = articleService.queryCountByCondition(ArticleTypeEnum.Cooperation.getType(), search);
            Pagination page = new Pagination(dataCount, this.pageSize, pageNo);
            List<Article> articleList = articleService.queryByCondition(page, search, ArticleTypeEnum.Cooperation.getType());

            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("articleList", articleList);
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("page", page);
            model.addAttribute("search", search);
            return "admin/cooperation/list";
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
            return "admin/cooperation/insert";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(ArticleDto articleDto) {
        try {
            articleDto.getArticle().setType(ArticleTypeEnum.Cooperation.getType());
            articleService.insertArticle(articleDto, getRequest());
            return "redirect:/admin/cooperation";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,
                           Model model) {
        try {
            Article article = articleService.queryById(Article.class, id);
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            if(article.getHasAttachment() == 1) {
                List<Attachment> attachmentList = attachmentService.queryByArticleId(id);
                model.addAttribute("attachmentList", attachmentList);
            }
            model.addAttribute("article", article);
            model.addAttribute("indexModuleList", indexModuleList);
            return "admin/cooperation/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(ArticleDto articleDto,
                         @RequestParam(value = "delAttachmentIds", required = false) String delAttachmentIds) {
        try {
            articleService.updateArticle(articleDto, delAttachmentIds, getRequest());
            return "redirect:/admin/cooperation";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Integer id,
                       Model model) {
        try {
            Article article = articleService.queryById(Article.class, id);
            if(article.getHasAttachment() == 1) {
                List<Attachment> attachmentList = attachmentService.queryByArticleId(id);
                model.addAttribute("attachmentList", attachmentList);
            }
            model.addAttribute("article", article);
            return "admin/cooperation/view";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        try {
            articleService.deleteById(id);
            return "redirect:/admin/cooperation";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
