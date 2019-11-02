package com.lvmen.community.controller;

import com.lvmen.community.dto.PaginationDTO;
import com.lvmen.community.dto.QuestionDTO;
import com.lvmen.community.mapper.QuestionMapper;
import com.lvmen.community.mapper.UserMapper;
import com.lvmen.community.model.Question;
import com.lvmen.community.model.User;
import com.lvmen.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lvmen on 2019/10/29
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size
                        ) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null){ // 一个cookie都没有会出现空指针异常，所以判空
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

        PaginationDTO pagination = questionService.list(page, size);

        model.addAttribute("pagination", pagination);

        return "index";
    }

}
