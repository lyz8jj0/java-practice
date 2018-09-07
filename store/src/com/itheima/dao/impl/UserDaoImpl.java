package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    /**
     * 添加用户
     *
     * @param user
     */
    @Override
    public void add(User user) throws Exception {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        qr.update(sql, user.getUid(), user.getUsername(), user.getPassword(),
                user.getName(), user.getEmail(), user.getTelephone(),
                user.getBirthday(), user.getSex(), user.getState(), user.getCode());
    }

    /**
     * 通过激活码获取一个用户
     *
     * @param code
     * @return
     * @throws Exception
     */
    @Override
    public User getByCode(String code) throws Exception {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where code = ? limit 1";
        return qr.query(sql, new BeanHandler<>(User.class), code);
    }

    /**
     * 修改用户
     *
     * @param user
     * @throws Exception
     */
    @Override
    public void update(User user) throws Exception {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set username = ? ,password = ?, name = ? ,email = ? ,birthday = ?,state = ? ,code = ? where uid = ?";
        qr.update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getBirthday(), user.getState(), null, user.getUid());
    }
}
