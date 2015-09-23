package com.economy.web.controller.admin;

import com.economy.common.entity.Certificate;
import com.economy.common.entity.IndexModule;
import com.economy.common.utils.WebConstants;
import com.economy.web.spring.AbstractController;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.web.spring.fileupload.PandaworkMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Certificate
 *
 * @author: zhangteng
 * @time: 2014/4/30 15:31
 */
@Controller
@RequestMapping("admin/certificate")
public class CertificateController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("certificateMenuActived", true);
    }

    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String list(Model model) {
        try {
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            List<Certificate> certificateList = certificateService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("certificateList", certificateList);
            return "admin/certificate/list";
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
            return "admin/certificate/insert";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Certificate certificate,
                         @RequestParam("imgFile") PandaworkMultipartFile imgFile) {
        try {
            certificateService.insertCertificate(certificate, imgFile, getRequest());
            return "redirect:/admin/certificate";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,
                           Model model) {
        try {
            Certificate certificate = certificateService.queryById(Certificate.class, id);
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("certificate", certificate);
            return "admin/certificate/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Certificate certificate,
                         @RequestParam("imgFile") PandaworkMultipartFile imgFile) {
        try {
            certificateService.updateCertificate(certificate, imgFile, getRequest());
            return "redirect:/admin/certificate";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        try {
            Certificate certificate = certificateService.queryById(Certificate.class, id);
            certificateService.delete(certificate);
            return "redirect:/admin/certificate";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
