package com.economy.web.controller.index;

import com.economy.common.entity.CommonFile;
import com.economy.common.entity.IndexModule;
import com.economy.common.utils.WebConstants;
import com.economy.web.spring.AbstractController;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.util.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * IndexCommonFileController
 *
 * @author: zhangteng
 * @time: 2014/5/3 16:19
 */
@Controller
@RequestMapping("index")
public class IndexCommonFileController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        try {
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("commonFileActive", true);
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
        }
    }

    @RequestMapping(value = "commonfiles/{indexModuleId}", method = RequestMethod.GET)
    public String list(@PathVariable("indexModuleId") Integer indexModuleId,
                       @RequestParam(value = "pageNo", required = false) Integer pageNo,
                       Model model) {
        try {
            if(pageNo == null) {
                pageNo = 1;
            }
            int dataCount = commonFileService.queryCountByCondition(indexModuleId.toString());
            Pagination page = new Pagination(dataCount, this.pageSize, pageNo);
            List<CommonFile> commonFileList = commonFileService.queryByCondition(page, indexModuleId.toString());

            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, indexModuleId);

            model.addAttribute("commonFileList", commonFileList);
            model.addAttribute("indexModule", indexModule);
            model.addAttribute("page", page);

            return "index/commonfile/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "commonfile/{commonFileId}", method = RequestMethod.GET)
    public void download(@PathVariable("commonFileId") Integer commonFileId) {
        try {
            commonFileService.downloadById(commonFileId, getRequest(), getResponse());
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
        }
    }
}
