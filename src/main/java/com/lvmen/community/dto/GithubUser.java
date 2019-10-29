package com.lvmen.community.dto;

import java.io.Serializable;

/**
 * github返回的用户信息
 * Created by lvmen on 2019/10/29
 */
public class GithubUser implements Serializable {

    private String name;
    private Long id;
    private String bio; // BIO的描述

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", bio='" + bio + '\'' +
                '}';
    }
}
