package com.example;

import com.example.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class SpringJUnitTests {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
        assertNotNull(userMapper);
        userMapper.getUsers().forEach(System.out::println);
    }
}
