package com.economy.web.controller.admin;

import com.economy.common.entity.IndexImg;
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
 * IndexImgController
 *
 * @author: zhangteng
 * @time: 2014/4/11 17:32
 */
@Controller
@RequestMapping("admin/index/img")
public class IndexImgController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        model.addAttribute("indexImgMenuActived", true);
    }

    @RequestMapping(value = {"","list"}, method = RequestMethod.GET)
    public String list(Model model) {
        try {
            List<IndexImg> indexImgList = indexImgService.queryAll();
            model.addAttribute("indexImgList", indexImgList);
            return "admin/index/img/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(Model model) {
        try {
            int sortNo = indexImgService.queryCount() + 1;
            model.addAttribute("sortNo", sortNo);
            return "admin/index/img/insert";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(IndexImg indexImg,
                         @RequestParam("imgFile") PandaworkMultipartFile imgFile) {
        try {
            indexImgService.insertIndexImg(indexImg, imgFile, getRequest());
            return "redirect:/admin/index/img";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,
                           Model model) {
        try {
            IndexImg indexImg = indexImgService.queryById(id);
            model.addAttribute("indexImg", indexImg);
            return "admin/index/img/update";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(IndexImg indexImg,
                         @RequestParam(value = "imgFile", required = false) PandaworkMultipartFile imgFile) {
        try {
            indexImgService.updateIndexImg(indexImg, imgFile, getRequest());
            return "redirect:/admin/index/img";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        try {
            IndexImg indexImg = indexImgService.queryById(id);
            indexImgService.delete(indexImg);
            return "redirect:/admin/index/img";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
