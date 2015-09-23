package com.economy.web.controller.admin;

import com.economy.common.entity.Contact;
import com.economy.common.entity.IndexModule;
import com.economy.common.utils.WebConstants;
import com.economy.web.spring.AbstractController;
import com.pandawork.core.exception.SSException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * ContactController
 *
 * @author: zhangteng
 * @time: 2014/4/30 17:14
 */
@Controller
@RequestMapping("admin/contact")
public class ContactController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("contactMenuActived", true);
    }

    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String list(Model model) {
        try {
            List<Contact> contactList = contactService.queryAll();
            model.addAttribute("contactList", contactList);
            return "admin/contact/list";
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
            return "admin/contact/insert";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Contact contact) {
        try {
            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, contact.getIndexModuleId());
            contact.setIndexModuleName(indexModule.getName());
            contactService.insert(contact);
            return "redirect:/admin/contact";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,
                           Model model) {
        try {
            Contact contact = contactService.queryById(Contact.class, id);
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("contact", contact);
            return "admin/contact/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Contact contact) {
        try {
            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, contact.getIndexModuleId());
            contact.setIndexModuleName(indexModule.getName());
            contactService.update(contact);
            return "redirect:/admin/contact";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        try {
            Contact contact = contactService.queryById(Contact.class, id);
            contactService.delete(contact);
            return "redirect:/admin/contact";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
