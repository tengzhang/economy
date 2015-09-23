package com.economy.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 常见问题实体
 *
 * @author: zhangteng
 * @time: 2014/4/11 10:40
 */
@Entity
@Table(name = "t_question")
public class Question extends AbstractEntity {

    private static final long serialVersionUID = -5536392646243333472L;

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
     * 问题
     */
    private String question;

    /**
     * 答案
     */
    private String answer;

    /**
     * 发布时间
     */
    @Column(name = "public_time")
    private Date publicTime;

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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }
}
