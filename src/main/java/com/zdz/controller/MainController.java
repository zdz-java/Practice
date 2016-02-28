package com.zdz.controller;

import com.zdz.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zdz on 16/2/28.
 */
@Controller
@RequestMapping("/main")
public class MainController {
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @RequestMapping("/test")
    public String test()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            System.out.println("this is come from controller test");
            System.out.println(userDao.getById(2));
        }
        finally {
            sqlSession.commit();
            sqlSession.close();
        }
        return "test";
    }

}
