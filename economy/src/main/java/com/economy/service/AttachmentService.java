package com.economy.service;

import com.economy.common.entity.Attachment;
import com.economy.common.service.BaseService;
import com.pandawork.core.exception.SSException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 附件service
 *
 * @author: zhangteng
 * @time: 2014/4/11 10:48
 */
public interface AttachmentService extends BaseService {

    /**
     * 根据通知id查询
     *
     * @param articleId
     * @return
     * @throws SSException
     */
    public List<Attachment> queryByArticleId(Integer articleId) throws SSException;

    /**
     * 根据id下载
     *
     * @param id
     * @param request
     * @param response
     * @throws SSException
     */
    public void downloadById(Integer id, HttpServletRequest request, HttpServletResponse response) throws SSException;

    /**
     * 根据通知id删除附件
     *
     * @param articleId
     * @throws SSException
     */
    public void deleteByArticleId(Integer articleId) throws SSException;
}
