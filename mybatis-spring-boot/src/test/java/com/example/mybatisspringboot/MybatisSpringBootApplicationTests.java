package com.example.mybatisspringboot;

import com.example.mybatisspringboot.dao.User;
import com.example.mybatisspringboot.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisSpringBootApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    UserMapper userMapper;

    @Test
    public void testMapper() {
        assertNotNull(userMapper);
        List<User> users = userMapper.selectUsers();
        assertNotNull(users);
        users.forEach(System.out::println);
    }

    @Autowired
    DataSourceTransactionManager transactionManager;
    @Test
    public void testTransaction() {
        assertNotNull(transactionManager);
        System.out.println(transactionManager);
    }
}
