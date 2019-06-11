package com.example.demo.user;

import com.example.demo.entity.user.User;
import com.example.demo.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : kongyy
 * @time : 2019/5/5 14:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void testAddUser() throws Exception{
        User user = new User();
        user.setUsername("aha");
        user.setPassword("123123");
        userService.addUser(user);
    }

    @Test
    public void testUpdatePassword() throws Exception{
        User user = new User();
        user.setUsername("孔一言");
        user.setPassword("666");
        userService.updateUserPassword(user);
    }

    @Test
    public void testPwdIsRight() throws Exception{
        String username = "孔一言";
        String password = "666";
        System.out.println(userService.pswIsTrue(username, password));
    }

    @Test
    public void testUpdateUser() throws Exception{
        User user = new User();
        user.setUsername("sadasd");
        user.setBirthday("aaaaaa");
        user.setSex("nv");
        user.setAddr("长春");
        user.setPhone("12312312312");
        user.setHpic("qweqwrqr");
        user.setUid(1);
        System.out.println(userService.updateUser(user));
    }

    @Test
    public void testSearchUser() throws Exception{
        User user = new User();
        String username = "admin";
        System.out.println(userService.searchUser(username));
    }

    @Test
    public void testListUserById() throws Exception{
        int uid = 1;
        System.out.println(userService.listUserById(uid));
    }

    @Test
    public void testGetUserId() throws Exception{
        String username = "admin";
        System.out.println(userService.getUserId(username));
    }

}
