package com.economy.web.controller.index;

import com.economy.common.entity.IndexModule;
import com.economy.common.entity.Major;
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
 * IndexMajorController
 *
 * @author: zhangteng
 * @time: 2014/5/2 11:03
 */
@Controller
@RequestMapping("index")
public class IndexMajorController extends AbstractController {

    @ModelAttribute
    public void setMenu(Model model) {
        try {
            List<IndexModule> indexModuleList = indexModuleService.queryAll();
            model.addAttribute("indexModuleList", indexModuleList);
            model.addAttribute("majorActive", true);
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
        }
    }

    @RequestMapping(value = "majors/{indexModuleId}", method = RequestMethod.GET)
    public String list(@PathVariable("indexModuleId") Integer indexModuleId,
                       Model model) {
        try {
            int dataCount = majorService.queryCountByCondition(indexModuleId.toString());
            Pagination page = new Pagination(dataCount, this.pageSize, 1);
            List<Major> majorList = majorService.queryByCondition(page, indexModuleId.toString());

            IndexModule indexModule = indexModuleService.queryById(IndexModule.class, indexModuleId);
            model.addAttribute("majorList", majorList);
            model.addAttribute("indexModule", indexModule);
            model.addAttribute("page", page);

            return "index/major/list";
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
