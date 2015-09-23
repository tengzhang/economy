package com.economy.web.controller.admin;

import com.economy.web.spring.AbstractController;
import com.pandawork.core.exception.SSException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * AttachmentController
 *
 * @author: zhangteng
 * @time: 2014/4/15 20:14
 */
@Controller
@RequestMapping("admin/attachment")
public class AttachmentController extends AbstractController {

    @RequestMapping(value = "download/{id}", method = RequestMethod.GET)
    public void download(@PathVariable("id") Integer id) {
        try {
            attachmentService.downloadById(id, getRequest(), getResponse());
        } catch (SSException e) {
            sendErrMsg(e.getMessage());
        }
    }
}
