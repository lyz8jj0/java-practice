package com.itheima.dao;

import com.itheima.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {

    /**
     * 转出钱
     *
     * @param fromUser
     * @param money
     */
    public void accountOut(String fromUser, String money) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            //编写sql
            String sql = "update account set money = money - ? where name = ?";

            //创建语句执行者
            st = conn.prepareStatement(sql);

            //设置参数

            //执行sql

            //处理

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }

    }
}
