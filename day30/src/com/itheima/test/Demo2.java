package com.itheima.test;

import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class Demo2 {
    @Test
    public void run1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //模拟多对多,双向的关联
        User u1 = new User();
        u1.setUsername("张三");
        User u2 = new User();
        u2.setUsername("赵四");

        //创建角色
        Role r1 = new Role();
        r1.setRname("经理");
        Role r2 = new Role();
        r2.setRname("演员");

        //双向关联
        u1.getRoles().add(r1);
        u1.getRoles().add(r2);
        r1.getUsers().add(u1);
        r2.getUsers().add(u1);

        u2.getRoles().add(r1);
        r1.getUsers().add(u2);

        session.save(u1);
        session.save(u2);
        session.save(r1);
        session.save(r2);

        tr.commit();
    }

    /**
     * 级联保存
     */
    @Test
    public void run2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //模拟多对多,双向的关联
        User u1 = new User();
        u1.setUsername("张三");
        User u2 = new User();
        u2.setUsername("赵四");

        //创建角色
        Role r1 = new Role();
        r1.setRname("经理");
        Role r2 = new Role();
        r2.setRname("演员");

        //双向关联
        u1.getRoles().add(r1);
        u1.getRoles().add(r2);
        u2.getRoles().add(r1);

        session.save(u1);
        session.save(u2);

        tr.commit();
    }

    /**
     * 现在:张三用户,有2个角色,经理和演员
     * 让张三没有演员的角色
     */
    @Test
    public void run3() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
       //查询张三用户
        User u1 = session.get(User.class, 3L);
        //查询角色
        Role r2 = session.get(Role.class, 4L);
        u1.getRoles().remove(r2);
        tr.commit();
    }
}
