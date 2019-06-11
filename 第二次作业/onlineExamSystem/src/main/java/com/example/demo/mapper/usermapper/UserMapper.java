package com.example.demo.mapper.usermapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 注册
     * @param user
     * @throws Exception
     */
    public void addUser(@Param("user") User user) throws Exception;

    /**
     * 密码是否正确
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public List<User> pswIsTrue(@Param("username") String username, @Param("password") String password) throws Exception;

    /**
     * 修改密码
     * @param user
     * @throws Exception
     */
    public void updateUser(@Param("user") User user) throws Exception;
}
