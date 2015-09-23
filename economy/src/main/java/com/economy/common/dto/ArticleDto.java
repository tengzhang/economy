package com.economy.common.dto;

import com.economy.common.entity.Article;
import com.pandawork.core.web.spring.fileupload.PandaworkMultipartFile;

import java.util.List;

/**
 * 文章Dto
 *
 * @author: zhangteng
 * @time: 2014/4/30 9:58
 */
public class ArticleDto {

    /**
     * 文章
     */
    private Article article;

    /**
     * 附件
     */
    private List<PandaworkMultipartFile> attachmentFileList;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<PandaworkMultipartFile> getAttachmentFileList() {
        return attachmentFileList;
    }

    public void setAttachmentFileList(List<PandaworkMultipartFile> attachmentFileList) {
        this.attachmentFileList = attachmentFileList;
    }
}
