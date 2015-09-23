package com.webexam.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 科目实体
 *
 * @author: zhangteng
 * @time: 14-1-16 上午10:35
 */
@Entity
@Table(name = "t_subject")
public class Subject extends AbstractEntity {

    private static final long serialVersionUID = -3649543992255759512L;

    @Id
    private Integer id;

    /**
     * 科目代码
     */
    private String code;

    /**
     * 科目名称
     */
    private String name;

    /**
     * 学分
     */
    private Integer credit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}
