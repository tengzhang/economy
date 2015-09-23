package com.economy.service.impl;

import com.economy.common.dto.ArticleDto;
import com.economy.common.entity.Article;
import com.economy.common.entity.Attachment;
import com.economy.common.entity.IndexModule;
import com.economy.common.exception.EconomyException;
import com.economy.common.service.impl.BaseServiceImpl;
import com.economy.common.utils.WebConstants;
import com.economy.mapper.ArticleMapper;
import com.economy.service.ArticleService;
import com.economy.service.AttachmentService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import com.pandawork.core.util.Pagination;
import com.pandawork.core.web.spring.fileupload.PandaworkMultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * ArticleServiceImpl
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:22
 */
@Service("articleService")
public class ArticleServiceImpl extends BaseServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private AttachmentService attachmentService;

    @Override
    public int queryCountByCondition(Integer type, String search) throws SSException {
        try {
            return articleMapper.queryCountByCondition(type, search);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public List<Article> queryByCondition(Pagination page, String search, Integer type) throws SSException {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            int pCurrent = 0, pSize = 10;
            if(page != null) {
                pCurrent = page.getCurrentFristPosition();
                pSize = page.getPageSize();
            }
            params.put("pCurrent", pCurrent);
            params.put("pSize", pSize);
            params.put("search", search);
            params.put("type", type);
            List<Article> articleList = articleMapper.queryByCondition(params);
            return articleList;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.SystemException);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public void insertArticle(ArticleDto articleDto, HttpServletRequest request) throws SSException {
        try {
            Article article = articleDto.getArticle();
            List<PandaworkMultipartFile> fileList = articleDto.getAttachmentFileList();
            // 添加文章
            IndexModule indexModule = this.queryById(IndexModule.class, article.getIndexModuleId());
            article.setIndexModuleName(indexModule.getName());
            article.setPublicTime(new Date());
            article = this.insert(article);

            // 添加附件
            if(fileList!=null && fileList.size()!=0) {
                List<Attachment> attachmentList = new ArrayList<Attachment>();
                for(PandaworkMultipartFile multipartFile : fileList) {
                    if(multipartFile.getFile()!=null && multipartFile.getFile().length()!=0) {
                        String path = this.uploadFile(multipartFile, WebConstants.ATTACHMENT_FOLDER, request);
                        Attachment attachment = new Attachment();
                        attachment.setName(multipartFile.getOriginalFilename());
                        attachment.setArticleId(article.getId());
                        attachment.setFilePath(path);
                        attachmentList.add(attachment);
                    }
                }
                if(attachmentList!=null && attachmentList.size()!=0) {
                    this.insertAll(attachmentList);
                }
            }
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.InserFail);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public void updateArticle(ArticleDto articleDto, String delAttachmentIds, HttpServletRequest request) throws SSException {
        try {
            Article article = articleDto.getArticle();
            List<PandaworkMultipartFile> fileList = articleDto.getAttachmentFileList();
            // 更新文章
            IndexModule indexModule = this.queryById(IndexModule.class, article.getIndexModuleId());
            article.setIndexModuleName(indexModule.getName());
            article.setPublicTime(new Date());
            this.update(article);

            // 添加新增的附件
            if(fileList!=null && fileList.size()!=0) {
                List<Attachment> attachmentList = new ArrayList<Attachment>();
                for(PandaworkMultipartFile multipartFile : fileList) {
                    if(multipartFile.getFile()!=null && multipartFile.getFile().length()!=0) {
                        String path = this.uploadFile(multipartFile, WebConstants.ATTACHMENT_FOLDER, request);
                        Attachment attachment = new Attachment();
                        attachment.setName(multipartFile.getOriginalFilename());
                        attachment.setArticleId(article.getId());
                        attachment.setFilePath(path);
                        attachmentList.add(attachment);
                    }
                }
                if(attachmentList!=null && attachmentList.size()!=0) {
                    this.insertAll(attachmentList);
                }
            }

            // 删除需删除的附件
            if(delAttachmentIds!=null && !("").equals(delAttachmentIds)) {
                String[] attachmentIdsStr = delAttachmentIds.split(",");
                for (String id : attachmentIdsStr) {
                    Attachment attachment = attachmentService.queryById(Attachment.class, Integer.parseInt(id));
                    attachmentService.delete(attachment);
                }
            }
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.UpdateFail);
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,SSException.class},propagation = Propagation.REQUIRED)
    public void deleteById(Integer id) throws SSException {
        try {
            // 先删除文章
            Article article = this.queryById(Article.class, id);
            this.delete(article);
            // 在删除文章对应的附件
            attachmentService.deleteByArticleId(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.DeleteFail);
        }
    }
}
