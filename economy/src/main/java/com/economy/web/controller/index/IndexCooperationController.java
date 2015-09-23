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
 * IndexCooperationController
 *
 * @author: zhangteng
 * @time: 2014/5/2 11:04
 */
@Controller
@RequestMapping("index")
public class IndexCooperationController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        try {
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("cooperationActive", true);
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
        }
    }

    @RequestMapping(value = "cooperations/{indexModuleId}", method = RequestMethod.GET)
    public String listZ(@PathVariable("indexModuleId") Integer indexModuleId,
                        Model model) {
        try {
            int dataCount = articleService.queryCountByCondition(ArticleTypeEnum.Cooperation.getType(), indexModuleId.toString());
            Pagination page = new Pagination(dataCount, this.pageSize, 1);
            List<Article> cooperationList = articleService.queryByCondition(page, indexModuleId.toString(), ArticleTypeEnum.Cooperation.getType());

            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, indexModuleId);

            model.addAttribute("cooperationList", cooperationList);
            model.addAttribute("indexModule", indexModule);
            model.addAttribute("page", page);

            return "index/cooperation/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "cooperation/{indexModuleId}/{cooperationId}", method = RequestMethod.GET)
    public String view(@PathVariable("indexModuleId") Integer indexModuleId,
                       @PathVariable("cooperationId") Integer cooperationId,
                       Model model) {
        try {
            Article cooperation = articleService.queryById(Article.class, cooperationId);
            if(cooperation.getHasAttachment() == 1) {
                List<Attachment> attachmentList = attachmentService.queryByArticleId(cooperationId);
                model.addAttribute("attachmentList", attachmentList);
            }
            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, indexModuleId);

            model.addAttribute("cooperation", cooperation);
            model.addAttribute("indexModule", indexModule);

            return "index/cooperation/view";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
