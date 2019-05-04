package com.mybatisplustest;


import com.mybatisplustest.entity.User;
import com.mybatisplustest.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisplusApplicationTest.class)
public class DemoApplicationTests {
    @Autowired
    UserService userService;
    @Test
    public void contextLoads() {

        User user=new User();
        user.setAge(19);
        user.setName("重说三");
        userService.insert(user);
    }

}
