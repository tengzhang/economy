package com.economy.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 首页版块实体
 *
 * @author: zhangteng
 * @time: 2014/4/11 10:34
 */
@Entity
@Table(name = "t_index_module")
public class IndexModule extends AbstractEntity {

    private static final long serialVersionUID = -1788682968369876392L;

    @Id
    private Integer id;

    /**
     * 版块名称
     */
    private String name;

    /**
     * 版块图标的class
     */
    @Column(name = "icon_class")
    private String iconClass;

    /**
     * 排列顺序
     */
    @Column(name = "sort_no")
    private Integer sortNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }
}
