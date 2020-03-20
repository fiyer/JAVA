package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {
        SqlSession session =  factory.openSession();
        List<User> users= session.selectList("com.itheima.dao.UserDao.findAll");
        session.close();
        return users;
    }

    public void saveUser(User user) {
        SqlSession session =  factory.openSession();
        session.insert("com.itheima.dao.UserDao.saveUser","user");
    }

    public void updateUser(User user) {

    }

    public void deleteUser(Integer userId) {

    }

    public User findById(Integer userId) {
        return null;
    }

    public List<User> findByName(String username) {
        return null;
    }

    public int findTotal() {
        return 0;
    }
}
