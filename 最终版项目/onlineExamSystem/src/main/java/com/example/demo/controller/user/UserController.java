package com.example.demo.controller.user;

import com.example.demo.entity.user.User;
import com.example.demo.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

/**
 * @author huawei
 */
@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 登录
     * @param username
     * @param password
     * @param request
     * @throws Exception
     */
    @RequestMapping("/login")
    public void login(String username, String password, HttpServletRequest request) throws Exception {
        if(userService.searchUser(username)){
            if(userService.pswIsTrue(username,password)){
                HttpSession session = request.getSession();
                session.setAttribute("usernameSession",username);
                System.out.println("登录成功！");
            }else {
                System.out.println("您的密码有误！");
            }
        }else{
            System.out.println("用户名不存在，请去注册！");
        }
    }

    /**
     * 注册
     * @param username
     * @param password
     * @throws Exception
     */
    @RequestMapping(value = "register")
    public void addUser(String username, String password) throws Exception{
        if(!userService.searchUser(username)){
            HttpServletRequest request = null;
            HttpSession session = request.getSession();
            session.setAttribute("usernameSession",username);
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setPower(0);
            if(userService.addUser(user)){
                System.out.println("注册成功！");
            }
        }else{
            System.out.println("用户名已存在，请直接登录！");
        }
    }

    /**
     * 个人中心
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "listUserByName")
    public List<User> listUserByName(HttpServletRequest request) throws Exception{
        List<User> userList = Collections.emptyList();
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.getUserId(username).getUid();
        userList = userService.listUserById(userId);
        return userList;
    }

//    /**
//     * 个人中心
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "listUserByName")
//    public List<User> listUserByName(String username) throws Exception{
//        List<User> userList = Collections.emptyList();
//        int userId = userService.getUserId(username).getUid();
//        userList = userService.listUserById(userId);
//        return userList;
//    }



}
