package com.example.demo.user;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
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
    public void testUpdate() throws Exception{
        User user = new User();
        user.setUsername("孔一言");
        user.setPassword("666");
        userService.updateUser(user);
    }

    @Test
    public void testPwdIsRight() throws Exception{
        String username = "孔一言";
        String password = "666";
        System.out.println(userService.pswIsTrue(username, password));
    }
}
