package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("toLogin")
    public String toLogin() throws Exception{
        return "login";
    }

    @RequestMapping("/login")
    public String login(@Param("username") String username, @Param("password") String password, ModelMap map) throws Exception{
        if(userService.pswIsTrue(username, password)){
            map.addAttribute("msg", "");
            return"index";
        }
        else{
            map.addAttribute("msg", "用户名或密码有误");
            return "login";
        }
    }

    @RequestMapping("/register")
    public String addUser(User user) throws Exception{
        userService.addUser(user);
        return "index";
    }

    @RequestMapping("/toAdd")
    public String toAdd() throws Exception{
        return "add";
    }
}
