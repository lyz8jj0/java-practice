package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {
    public void save1(User u1) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(u1);
    }

    public void save2(User u2) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(u2);
    }
}
