package com.lvmen.community.controller;

import com.lvmen.community.dto.AccessTokenDTO;
import com.lvmen.community.dto.GithubUser;
import com.lvmen.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * github认证控制器
 * Created by lvmen on 2019/10/29
 */
@Controller
public class AuthorizeController {

    @Value("${github.client.id}") // 会去取配置文件中配置的值
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping(value = "/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println("欢迎："+user.getName());
        return "index";
    }

}
