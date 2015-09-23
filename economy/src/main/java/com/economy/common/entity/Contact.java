package com.economy.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 联系我们实体
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:29
 */
@Entity
@Table(name = "t_contact")
public class Contact extends AbstractEntity {

    private static final long serialVersionUID = 390736670654897347L;

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
     * 通信地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 联系人
     */
    @Column(name = "contact_people")
    private String contactPeople;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPeople() {
        return contactPeople;
    }

    public void setContactPeople(String contactPeople) {
        this.contactPeople = contactPeople;
    }
}
