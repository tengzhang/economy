package com.economy.service.impl;

import com.economy.common.entity.Attachment;
import com.economy.common.exception.EconomyException;
import com.economy.common.service.impl.BaseServiceImpl;
import com.economy.common.utils.WebConstants;
import com.economy.mapper.AttachmentMapper;
import com.economy.service.AttachmentService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 附件service实现
 *
 * @author: zhangteng
 * @time: 2014/4/11 10:48
 */
@Service("attachmentService")
public class AttachmentServiceImpl extends BaseServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public List<Attachment> queryByArticleId(Integer noticeId) throws SSException {
        try {
            return attachmentMapper.queryByArticleId(noticeId);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public void downloadById(Integer id, HttpServletRequest request, HttpServletResponse response) throws SSException {
        try {
            Attachment attachment = this.queryById(Attachment.class, id);
            String filename = attachment.getName();
            String path =  request.getSession().getServletContext().getRealPath("/resources/") +  attachment.getFilePath();
            this.downloadFile(filename, path, response);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.SystemException);
        }
    }

    @Override
    public void deleteByArticleId(Integer articleId) throws SSException {
        try {
            attachmentMapper.deleteByArticleId(articleId);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.DeleteFail);
        }
    }
}
