package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

import java.sql.SQLException;

public class UserService {
    public User checkUsername4Ajax(String username) throws SQLException {
        return new UserDao().getUserByUsername4Ajax(username);
    }
}
