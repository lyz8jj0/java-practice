package com.itheima.service;

import com.itheima.dao.AccountDao4tl;
import com.itheima.utils.DataSourceUtils;

import java.sql.Connection;

public class AccountService4tl {
    /**
     * 转账
     *
     * @param fromUser 转出方
     * @param toUser   转入方
     * @param money    金额
     * @return
     */
    public String account(String fromUser, String toUser, String money) throws Exception {
        AccountDao4tl dao = new AccountDao4tl();

        Connection conn = null;

        try {
            //0开启事务
            DataSourceUtils.startTransaction();

            //1,转出
            dao.accountOut(fromUser, money);

//            int i = 1 / 0;
            //2,转入
            dao.accountIn(toUser, money);

            //3,事务提交
            DataSourceUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            //事务回滚
            DataSourceUtils.rollbackAndClose();

            throw e;

        }

        return null;
    }
}
