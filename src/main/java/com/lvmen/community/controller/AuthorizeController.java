package com.lvmen.community.controller;

import com.lvmen.community.dto.AccessTokenDTO;
import com.lvmen.community.dto.GithubUser;
import com.lvmen.community.mapper.UserMapper;
import com.lvmen.community.model.User;
import com.lvmen.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

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
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO); // 去github请求accessToken
        GithubUser githubUser = githubProvider.getUser(accessToken); // 去github请求用户信息

        if(githubUser != null){

            // 登录成功，写cookie和写session
            System.out.println(githubUser.getName() + "登录成功了！");
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());

            userMapper.insert(user);
            request.getSession().setAttribute("user", githubUser); // 我们把信息放到session中，服务器就可以读取session中的对象。cookie也会有一个JSESSIONID的cookie
            return "redirect:/"; // 重定向到index

        }else {
            // 登录失败
            return "redirect:/";
        }
    }

}
