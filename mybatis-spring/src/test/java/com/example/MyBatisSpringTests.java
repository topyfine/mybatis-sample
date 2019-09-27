package com.example;

import com.example.dao.User;
import com.example.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
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

//    @Test
//    public void testMapper2() {
//        SqlSessionFactory sqlSessionFactory = applicationContext.getBean(SqlSessionFactory.class);
//        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
//        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
//        assertNotNull(mapper);
//        mapper.getUsers().forEach(System.out::println);
//    }

//    @Test
//    public void testMapper3() throws Exception {
//        SqlSessionFactory sqlSessionFactory = applicationContext.getBean(SqlSessionFactory.class);
//        MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<>(UserMapper.class);
//        factoryBean.setSqlSessionFactory(sqlSessionFactory);
//        UserMapper userMapper = factoryBean.getObject();
//        assertNotNull(userMapper);
//    }
}
