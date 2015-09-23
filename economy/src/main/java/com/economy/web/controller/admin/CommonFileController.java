package com.economy.web.controller.admin;

import com.economy.common.entity.CommonFile;
import com.economy.common.entity.IndexModule;
import com.economy.common.utils.WebConstants;
import com.economy.web.spring.AbstractController;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import com.pandawork.core.web.spring.fileupload.PandaworkMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CommonFileController
 *
 * @author: zhangteng
 * @time: 2014/5/1 16:37
 */
@Controller
@RequestMapping("admin/commonfile")
public class CommonFileController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("commonFileMenuActived", true);
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
            int dataCount = commonFileService.queryCountByCondition(search);
            Pagination page = new Pagination(dataCount, this.pageSize, pageNo);
            List<CommonFile> commonFileList = commonFileService.queryByCondition(page, search);

            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("commonFileList", commonFileList);
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("page", page);
            model.addAttribute("search", search);
            return "admin/commonfile/list";
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
            return "admin/commonfile/insert";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(@RequestParam("indexModuleId") Integer indexModuleId,
                         @RequestParam("file") PandaworkMultipartFile file) {
        try {
            commonFileService.insertCommonFile(indexModuleId, file, getRequest());
            return "redirect:/admin/commonfile";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,
                           Model model) {
        try {
            CommonFile commonFile = commonFileService.queryById(CommonFile.class, id);
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("commonFile", commonFile);
            return "admin/commonfile/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(CommonFile commonFile,
                         @RequestParam("file") PandaworkMultipartFile file) {
        try {
            commonFileService.updateCommonFile(commonFile, file, getRequest());
            return "redirect:/admin/commonfile";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        try {
            CommonFile commonFile = commonFileService.queryById(CommonFile.class, id);
            commonFileService.delete(commonFile);
            return "redirect:/admin/commonfile";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
