package com.example.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MyBatisTests {

    private SqlSessionFactory sqlSessionFactory;

    SqlSession session;

    @Before
    public void setUp() throws Exception {
        // classpath
        String res = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(res);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testContext() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            assertNotNull(session);
        }
    }

    @Test
    public void testMapper() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Object> objects = session.selectList("org.mybatis.example.UserMapper.selectUsers");
//            System.out.println(objects);
            assertNotNull(objects);
        }
    }
}
