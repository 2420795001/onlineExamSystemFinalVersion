package com.example.demo.superuser;

import com.example.demo.service.superuser.SuperUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : kongyy
 * @time : 2019/5/25 20:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SuperUserServiceTest {

    @Autowired
    SuperUserService superUserService;

    @Test
    public void testUpdateUser() throws Exception{
        int id = 1;
        System.out.println(superUserService.updateUser(id));
    }

    @Test
    public void testDelUser() throws Exception{
        int uid = 2;
        System.out.println(superUserService.delUser(uid));
    }
}
