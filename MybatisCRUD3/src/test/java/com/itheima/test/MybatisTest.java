package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private UserDao userDao;

    @Before
    public void init(){
        try {
            in= Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            userDao =new UserDaoImpl(factory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destory(){
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testSave(){
        User user = new User();
                user.setUsername("Mybatistest1");
                user.setBirthday(new Date());
                user.setSex("男");
                user.setAddress("济宁市");
        System.out.println("保存操作前"+user);
        userDao.saveUser(user);
        System.out.println("保存操作后"+user);
    }

    @Test
    public void testupdate(){
        User user = new User();
        user.setId(11);
        user.setUsername("Mybatistest2");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("成都市");
        userDao.updateUser(user);
    }
    @Test
    public void testdelete(){
        userDao.deleteUser(10);
    }
    @Test
    public void testFindOne(){
        User user = userDao.findById(11);
        System.out.println(user);
    }
    @Test
    private void testFindName(){
        List<User> users  =userDao.findByName("%jia%");
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testFindTotal(){
        int count = userDao.findTotal();
        System.out.println(count);
    }
}
