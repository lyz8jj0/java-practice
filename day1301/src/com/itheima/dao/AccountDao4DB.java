package com.itheima.dao;

import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class AccountDao4DB {
    public void accountOut(String fromUser, String money) throws SQLException {
        //创建queryrunner
        QueryRunner qr = new QueryRunner();

        //编写sql
        String sql = "update account set money = money - ? where name = ?";

        //执行sql
        qr.update(DataSourceUtils.getConnection(), sql, money, fromUser);
    }

    public void accountIn(String toUser, String money) throws SQLException {
        //创建queryrunner
        QueryRunner qr = new QueryRunner();

        //编写sql
        String sql = "update account set money = money + ? where name = ?";

        //执行sql
        qr.update(DataSourceUtils.getConnection(), sql, money, toUser);
    }
}
