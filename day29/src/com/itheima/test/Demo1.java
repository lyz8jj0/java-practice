package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class Demo1 {
    @Test
    public void run1(){
        //获取session
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        //保存数据
        User user = new User();
        user.setName("小风");
        user.setAge(28);

        session.save(user);

        tr.commit();
        session.close();

    }
}
