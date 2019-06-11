package com.example.demo.service.superuser.impl;

import com.example.demo.mapper.superuser.SuperUserMapper;
import com.example.demo.service.superuser.SuperUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : kongyy
 * @time : 2019/5/25 16:22
 */
@Service
public class SuperUserServiceImpl implements SuperUserService {

    @Autowired
    SuperUserMapper superUserMapper;

    @Override
    public boolean delUser(int uid) throws Exception{
        return superUserMapper.delUser(uid);
    }

    @Override
    public boolean updateUser(int uid) throws Exception{
        return superUserMapper.updateUser(uid);
    }
}
