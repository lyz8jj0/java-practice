package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

import java.sql.SQLException;

/**
 * Created by Administrator on 2018/7/27.
 */
public class UserService {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return User
     */
    public User login(String username, String password) throws SQLException {
        //调用dao
        UserDao dao = new UserDao();
        return dao.getUserByUsernameAndPwd(username,password);
    }


    /**
     * 用户注册
     * @param user 用户
     * @return
     */
    public int regist(User user) throws SQLException {
        //调用dao
        UserDao dao = new UserDao();
        return dao.addUser(user);


    }
}
