package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

import java.sql.SQLException;

public class UserService {
    public User getUserByUsernameAndPwd(String username, String password) throws SQLException {
        return new UserDao().getUserByUsernameAndPwd(username, password);
    }
}
