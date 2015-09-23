package com.economy.web.controller.index;

import com.economy.common.entity.Article;
import com.economy.common.entity.ButtonUrl;
import com.economy.common.entity.IndexImg;
import com.economy.common.entity.IndexModule;
import com.economy.common.enums.ArticleTypeEnum;
import com.economy.common.utils.WebConstants;
import com.economy.web.spring.AbstractController;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * IndexController
 *
 * @author: zhangteng
 * @time: 2014/5/1 21:17
 */
@Controller
@RequestMapping("")
public class IndexController extends AbstractController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        try {
            // 平台链接
            ButtonUrl jjksUrl = buttonUrlService.queryById(ButtonUrl.class, 1);
            model.addAttribute("jjksUrl", jjksUrl.getUrl());

            ButtonUrl zxksUrl = buttonUrlService.queryById(ButtonUrl.class, 2);
            model.addAttribute("zxksUrl", zxksUrl.getUrl());

            // 首页版块
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            // 首页图片
            List<IndexImg> indexImgList = indexImgService.queryAll();
            // 通知
            int dataCount = articleService.queryCountByCondition(ArticleTypeEnum.Notice.getType(), null);
            Pagination page = new Pagination(dataCount, 7, 1);
            List<Article> noticeList = articleService.queryByCondition(page, null, ArticleTypeEnum.Notice.getType());


            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("indexImgList", indexImgList);
            model.addAttribute("noticeList", noticeList);
            return "index/index";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
