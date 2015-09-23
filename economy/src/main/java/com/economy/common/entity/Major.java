package com.economy.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 专业实体
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:01
 */
@Entity
@Table(name = "t_major")
public class Major extends AbstractEntity {

    private static final long serialVersionUID = -3714991638423169357L;

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
     * 专业名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
