package com.itheima.service;

import com.itheima.dao.AccountDao;
import com.itheima.utils.JdbcUtils;

import java.sql.Connection;

public class AccountService {
    /**
     * 转账
     *
     * @param fromUser 转出方
     * @param toUser   转入方
     * @param money    金额
     * @return
     */
    public String account(String fromUser, String toUser, String money) throws Exception {
        AccountDao dao = new AccountDao();

        Connection conn = null;

        try {
            //0开启事务
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);

            //1,转出
            dao.accountOut(conn, fromUser, money);

//            int i = 1 / 0;
            //2,转入
            dao.accountIn(conn, toUser, money);

            //3,事务提交
            conn.commit();
            JdbcUtils.closeConn(conn);
        } catch (Exception e) {
            e.printStackTrace();

            //事务回滚
            conn.rollback();
            JdbcUtils.closeConn(conn);
            throw e;

        }

        return null;
    }
}
