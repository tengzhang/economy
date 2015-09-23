package com.economy.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 通知附件实体
 *
 * @author: zhangteng
 * @time: 2014/4/11 10:31
 */
@Entity
@Table(name = "t_attachment")
public class Attachment extends AbstractEntity {

    private static final long serialVersionUID = 3639145779911017533L;

    @Id
    private Integer id;

    /**
     * 通知主键
     */
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 附件名称
     */
    private String name;

    /**
     * 附件保存路径
     */
    @Column(name = "file_path")
    private String filePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
