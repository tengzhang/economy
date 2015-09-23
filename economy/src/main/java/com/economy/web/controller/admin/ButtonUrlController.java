package com.economy.web.controller.admin;

import com.economy.common.entity.ButtonUrl;
import com.economy.common.utils.WebConstants;
import com.economy.web.spring.AbstractController;
import com.pandawork.core.exception.SSException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ButtonUrlController
 *
 * @author: zhangteng
 * @time: 2014/5/3 16:48
 */
@Controller
@RequestMapping("admin/buttonurl")
public class ButtonUrlController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("buttonUrlMenuActived", true);
    }

    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String list(Model model) {
        try {
            ButtonUrl jjksUrl = buttonUrlService.queryById(ButtonUrl.class, 1);
            model.addAttribute("jjksUrl", jjksUrl.getUrl());

            ButtonUrl zxksUrl = buttonUrlService.queryById(ButtonUrl.class, 2);
            model.addAttribute("zxksUrl", zxksUrl.getUrl());
            return "admin/buttonurl/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,
                           Model model) {
        try {
            ButtonUrl buttonUrl = buttonUrlService.queryById(ButtonUrl.class, id);
            model.addAttribute("buttonUrl", buttonUrl);
            return "admin/buttonurl/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    private String update(ButtonUrl buttonUrl) {
        try {
            String url = buttonUrl.getUrl();
            if(url.startsWith("http://") == false) {
                url = "http://" + url;
                buttonUrl.setUrl(url);
            }
            buttonUrlService.update(buttonUrl);
            return "redirect:/admin/buttonurl";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
