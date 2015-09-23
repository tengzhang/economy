package com.webexam.web.controller;

import com.pandawork.core.exception.SSException;
import com.webexam.common.utils.WebConstants;
import com.webexam.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * IndexController
 *
 * @author: zhangteng
 * @time: 14-1-12 下午5:01
 */
@Controller
@RequestMapping(value = "")
public class IndexController extends AbstractController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "student/index";
    }
}
