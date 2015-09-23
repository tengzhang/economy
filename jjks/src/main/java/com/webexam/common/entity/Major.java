package com.webexam.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 专业实体
 *
 * @author: zhangteng
 * @time: 14-1-15 下午4:52
 */
@Entity
@Table(name = "t_major")
public class Major extends AbstractEntity {

    private static final long serialVersionUID = 4257512275515247703L;

    @Id
    private Integer id;

    /**
     * 专业代码
     */
    private String code;

    /**
     * 专业名称
     */
    private String name;

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
}
