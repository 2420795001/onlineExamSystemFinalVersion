package com.example.demo.service.user;

import com.example.demo.entity.user.User;

import java.util.List;


public interface UserService {

    /**
     * 注册
     * @param user
     * @throws Exception
     */
    public boolean addUser(User user) throws Exception;

    /**
     * 修改密码
     * @param user
     * @throws Exception
     */
    public void updateUserPassword(User user) throws Exception;


    /**
     * 判断密码是否正确
     * @param userName
     * @param userPassword
     * @return
     * @throws Exception
     */
    public boolean pswIsTrue(String userName, String userPassword) throws Exception;


    /**
     * 修改用户信息
     * @param user
     * @return
     * @throws Exception
     */
    public boolean updateUser(User user) throws Exception;

    public boolean searchUser(String username) throws Exception;

    public List<User> listUserById(int uid) throws Exception;

    public User getUserId(String username) throws Exception;

}
