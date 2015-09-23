package com.economy.web.controller.index;

import com.economy.common.entity.Certificate;
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
 * IndexCertificateController
 *
 * @author: zhangteng
 * @time: 2014/5/3 15:18
 */
@Controller
@RequestMapping("index")
public class IndexCertificateController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        try {
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("certificateActive", true);
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
        }
    }

    @RequestMapping(value = "certificates/{indexModuleId}", method = RequestMethod.GET)
    public String list(@PathVariable("indexModuleId") Integer indexModuleId,
                       Model model) {
        try {
            List<Certificate> certificateList = certificateService.queryByIndexModuleId(indexModuleId);
            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, indexModuleId);

            model.addAttribute("certificateList", certificateList);
            model.addAttribute("indexModule", indexModule);

            return "index/certificate/view";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
