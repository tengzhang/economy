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
 * IndexBrochure
 *
 * @author: zhangteng
 * @time: 2014/5/3 15:45
 */
@Controller
@RequestMapping("index")
public class IndexBrochureController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        try {
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("brochureActive", true);
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
        }
    }

    @RequestMapping(value = "brochures/{indexModuleId}", method = RequestMethod.GET)
    public String list(@PathVariable("indexModuleId") Integer indexModuleId,
                       Model model) {
        try {
            int dataCount = articleService.queryCountByCondition(ArticleTypeEnum.Brochure.getType(), indexModuleId.toString());
            Pagination page = new Pagination(dataCount, this.pageSize, 1);
            List<Article> brochureList = articleService.queryByCondition(page, indexModuleId.toString(), ArticleTypeEnum.Brochure.getType());

            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, indexModuleId);

            model.addAttribute("brochureList", brochureList);
            model.addAttribute("indexModule", indexModule);
            model.addAttribute("page", page);

            return "index/brochure/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "brochure/{indexModuleId}/{brochureId}", method = RequestMethod.GET)
    public String view(@PathVariable("indexModuleId") Integer indexModuleId,
                       @PathVariable("brochureId") Integer brochureId,
                       Model model) {
        try {
            Article brochure = articleService.queryById(Article.class, brochureId);
            if(brochure.getHasAttachment() == 1) {
                List<Attachment> attachmentList = attachmentService.queryByArticleId(brochureId);
                model.addAttribute("attachmentList", attachmentList);
            }
            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, indexModuleId);

            model.addAttribute("brochure", brochure);
            model.addAttribute("indexModule", indexModule);

            return "index/brochure/view";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
