package com.economy.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 证书实体
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:13
 */
@Entity
@Table(name = "t_certificate")
public class Certificate extends AbstractEntity {

    private static final long serialVersionUID = 3273144790170279115L;

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
     * 证书名称
     */
    private String name;

    /**
     * 证书图片路径
     */
    @Column(name = "img_path")
    private String imgPath;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }
}
