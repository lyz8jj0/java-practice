package com.itheima.service;

import com.itheima.dao.AccountDao;

public class AccountService {
    /**
     * 转账
     * @param fromUser 转出方
     * @param toUser 转入方
     * @param money 金额
     * @return
     */
    public String account(String fromUser, String toUser, String money) {
        AccountDao dao = new AccountDao();

        //1,转出
        dao.accountOut(fromUser,money);

        //2,转入
        dao.accountOut(toUser,money);

        return null;
    }
}
