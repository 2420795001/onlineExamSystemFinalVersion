package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.usermapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public void addUser(User user) throws Exception{
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception{
        userMapper.updateUser(user);
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
}
