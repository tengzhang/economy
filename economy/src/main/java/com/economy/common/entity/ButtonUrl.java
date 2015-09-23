package com.economy.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ButtonUrl
 *
 * @author: zhangteng
 * @time: 2014/5/3 16:43
 */
@Entity
@Table(name = "t_button_url")
public class ButtonUrl extends AbstractEntity {

    private static final long serialVersionUID = -4527384994435385599L;

    @Id
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 地址
     */
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
