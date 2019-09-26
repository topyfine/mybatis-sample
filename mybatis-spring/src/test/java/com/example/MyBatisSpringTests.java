package com.example;

import com.example.dao.User;
import com.example.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple App.
 */
public class MyBatisSpringTests {
    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        // context init.
        applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
    }

    @Test
    public void testMapper() {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        assertNotNull(userMapper);
        List<User> users = userMapper.getUsers();
        System.out.println(users);
        assertNotNull(users);
    }

}
