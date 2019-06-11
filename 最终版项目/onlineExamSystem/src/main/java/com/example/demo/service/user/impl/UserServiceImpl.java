package com.example.demo.service.user.impl;

import com.example.demo.entity.user.User;
import com.example.demo.mapper.user.UserMapper;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;



    @Override
    public boolean addUser(User user) throws Exception{
        return userMapper.addUser(user);
    }

    @Override
    public void updateUserPassword(User user) throws Exception{
        userMapper.updateUserPassword(user);
    }

    @Override
    public boolean pswIsTrue(String username, String password) throws Exception{
        boolean flag = false;
        List<User> list = userMapper.pswIsTrue(username,password);
        if(list.size()!=0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean updateUser(User user) throws Exception{
        return userMapper.updateUser(user);
    }

    @Override
    public boolean searchUser(String username) throws Exception{
        boolean flag = false;
        List<User> list = Collections.emptyList();
        list = userMapper.searchUser(username);
        if(list.size() != 0){
            flag = true;
        }
        return flag;
    }

    @Override
    public List<User> listUserById(int uid) throws Exception{
        List<User> list = Collections.emptyList();
        list = userMapper.listUserById(uid);
        return  list;
    }

    @Override
    public User getUserId(String username) throws Exception{
        User user = userMapper.getUserId(username);
        return user;
    }
}
