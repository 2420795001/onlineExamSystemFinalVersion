package com.example.demo.mapper.user;

import com.example.demo.entity.user.User;
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
    public boolean addUser(@Param("user") User user) throws Exception;

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
    public void updateUserPassword(@Param("user") User user) throws Exception;

    /**
     * 修改用户信息
     * @param user
     * @return
     * @throws Exception
     */
    public boolean updateUser(@Param("user") User user) throws Exception;

    /**
     * 根据用户名找到用户信息
     * @param username
     * @return
     * @throws Exception
     */
    public List<User> searchUser(@Param("username") String username) throws Exception;

    /**
     * 根据用户id找到用户信息
     * @param uid
     * @return
     * @throws Exception
     */
    public List<User> listUserById(@Param("uid") int uid) throws Exception;

    /**
     * 根据用户名找到用户的id
     * @param username
     * @return
     * @throws Exception
     */
    public User getUserId(@Param("username") String username) throws Exception;
}
