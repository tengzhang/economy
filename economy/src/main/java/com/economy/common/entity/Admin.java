package com.economy.common.entity;

import com.pandawork.core.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 管理员实体
 *
 * @author: zhangteng
 * @time: 14-1-16 下午2:36
 */
@Entity
@Table(name = "t_admin")
public class Admin extends AbstractEntity {

    private static final long serialVersionUID = 8092128289594441457L;

    @Id
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
