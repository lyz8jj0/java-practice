package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;


public class UserDao {
    /**
     * 通过用户名获取一个用户
     *
     * @param username
     * @return
     */
    public User getUserByUsername4Ajax(String username) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select * from user where username = ? limit 1";

        return qr.query(sql, new BeanHandler<>(User.class), username);
    }
}
