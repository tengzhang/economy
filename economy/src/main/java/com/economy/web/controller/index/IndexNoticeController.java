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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * NoticeController
 *
 * @author: zhangteng
 * @time: 2014/5/2 11:04
 */
@Controller("indexNoticeController")
@RequestMapping("index")
public class IndexNoticeController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        try {
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
        }
    }

    @RequestMapping(value = "notices", method = RequestMethod.GET)
    public String list(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                       Model model) {
        try {
            if(pageNo == null) {
                pageNo = 1;
            }
            int dataCount = articleService.queryCountByCondition(ArticleTypeEnum.Notice.getType(), null);
            Pagination page = new Pagination(dataCount, this.pageSize, pageNo);
            List<Article> noticeList = articleService.queryByCondition(page, null, ArticleTypeEnum.Notice.getType());
            model.addAttribute("noticeList", noticeList);
            model.addAttribute("page", page);
            return "index/notice/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "notice/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Integer id,
                       Model model) {
        try {
            Article notice = articleService.queryById(Article.class, id);
            if(notice.getHasAttachment() == 1) {
                List<Attachment> attachmentList = attachmentService.queryByArticleId(id);
                model.addAttribute("attachmentList", attachmentList);
            }
            model.addAttribute("notice", notice);
            return "index/notice/view";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
