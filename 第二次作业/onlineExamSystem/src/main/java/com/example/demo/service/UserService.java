package com.example.demo.service;

import com.example.demo.entity.User;


public interface UserService {

    /**
     * 注册
     * @param user
     * @throws Exception
     */
    public void addUser(User user) throws Exception;

    /**
     * 修改密码
     * @param user
     * @throws Exception
     */
    public void updateUser(User user) throws Exception;


    /**
     * 判断密码是否正确
     * @param userName
     * @param userPassword
     * @return
     * @throws Exception
     */
    public boolean pswIsTrue(String userName, String userPassword) throws Exception;
}
