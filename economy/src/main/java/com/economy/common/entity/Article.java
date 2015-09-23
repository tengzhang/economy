package com.economy.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 文章实体
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:18
 */
@Entity
@Table(name = "t_article")
public class Article extends AbstractEntity {

    private static final long serialVersionUID = 5936072968148001482L;

    @Id
    private Integer id;

    /**
     * 首页版块主键
     */
    @Column(name = "index_module_id")
    private Integer indexModuleId;

    /**
     * 首页版块名称
     */
    @Column(name = "index_module_name")
    private String indexModuleName;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 发布时间
     */
    @Column(name = "public_time")
    private Date publicTime;

    /**
     * 文章类型(1-招生简章，2-课程设置，3-合作助学单位，4-通知)
     */
    private Integer type;

    /**
     * 是否有附件(0:没有,1:有)
     */
    @Column(name = "has_attachment")
    private Integer hasAttachment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndexModuleId() {
        return indexModuleId;
    }

    public void setIndexModuleId(Integer indexModuleId) {
        this.indexModuleId = indexModuleId;
    }

    public String getIndexModuleName() {
        return indexModuleName;
    }

    public void setIndexModuleName(String indexModuleName) {
        this.indexModuleName = indexModuleName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getHasAttachment() {
        return hasAttachment;
    }

    public void setHasAttachment(Integer hasAttachment) {
        this.hasAttachment = hasAttachment;
    }
}
