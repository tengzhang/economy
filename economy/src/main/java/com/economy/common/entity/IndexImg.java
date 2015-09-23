package com.economy.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 首页轮播图片实体
 *
 * @author: zhangteng
 * @time: 2014/4/5 21:08
 */
@Entity
@Table(name = "t_index_img")
public class IndexImg extends AbstractEntity {

    private static final long serialVersionUID = -2329877847341670070L;

    @Id
    private Integer id;

    /**
     * 首页图片路径
     */
    @Column(name = "img_path")
    private String imgPath;

    /**
     * 图片描述
     */
    private String description;

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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }
}
