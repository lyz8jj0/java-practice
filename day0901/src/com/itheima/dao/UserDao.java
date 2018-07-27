package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by Administrator on 2018/7/27.
 */
public class UserDao {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public User getUserByUsernameAndPwd(String username, String password) throws SQLException {
        //创建queryrunner
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        //编写sql
        String sql = "select * from user where username = ? and password = ?";
        //执行sql
        User user = qr.query(sql, new BeanHandler<>(User.class), username, password);
        return user;
    }
}
