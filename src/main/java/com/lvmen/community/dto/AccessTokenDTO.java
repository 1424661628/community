package com.lvmen.community.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lvmen on 2019/10/29
 */
@Data
public class AccessTokenDTO implements Serializable {

    private String client_id;
    private String client_secret;
    private String code;;
    private String redirect_uri;;
    private String state;
}
