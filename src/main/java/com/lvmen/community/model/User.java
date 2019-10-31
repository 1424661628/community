package com.lvmen.community.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lvmen on 2019/10/30
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl; // 头像地址

}
