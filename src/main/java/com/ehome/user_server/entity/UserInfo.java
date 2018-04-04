package com.ehome.user_server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 此处编写本类功能说明
 * author：SunTianJie
 * create time：2018/3/29 13:22
 */
@Entity(name="userinfo")
public class UserInfo {

    @Id
    private long id;

    @Column(name="name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
