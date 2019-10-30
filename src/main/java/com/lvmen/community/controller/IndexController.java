package com.lvmen.community.controller;

import com.lvmen.community.mapper.UserMapper;
import com.lvmen.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by lvmen on 2019/10/29
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/")
    public String index(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();

        if (cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("token")){
                    String cookieValue = cookie.getValue();
                    User user = userMapper.findByToken(cookieValue); // 通过token查询用户信息
                    if (user != null){ // 将user放到session中
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        return "index";
    }

}