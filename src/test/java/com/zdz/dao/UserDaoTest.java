package com.zdz.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zdz on 16/2/28.
 */
public class UserDaoTest {
    @Test
    public void test() throws IOException {
        String resource = "Mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);

        SqlSession openSession = factory.openSession();
        UserDao userDao = openSession.getMapper(UserDao.class);
        Assert.assertEquals("wei",userDao.getById(2).getName());
        openSession.commit();
        openSession.close();
    }

}
