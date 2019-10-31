package com.lvmen.community.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * github返回的用户信息
 * Created by lvmen on 2019/10/29
 */
@Data
public class GithubUser implements Serializable {

    private String name;
    private Long id;
    private String bio; // BIO的描述
    private String avatar_url; // 头像地址
}
