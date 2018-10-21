package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class Demo4 {
    /**
     * 测试Query的查询接口
     */
    @Test
    public void run1() {
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        //查询的方式
        Query query = session.createQuery("from User");
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user);
        }
        tr.commit();
        session.close();
    }

    /**
     * 添加查询的条件
     */
    @Test
    public void run2() {
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        //查询的方式HQL from User where 属性 条件
        Query query = session.createQuery("from User where age > ?");
        //设置值
        query.setInteger(0, 28);
        //查询
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user);
        }

        tr.commit();
        session.close();
    }

    /**
     * Criteria接口:条件查询,非常适合
     */
    @Test
    public void run5() {
        Session session = HibernateUtils.getSession();
//        Transaction tr = session.beginTransaction();
        //先获取criteria接口
        Criteria criteria = session.createCriteria(User.class);
        //没有添加条件,查询所的数据
        List<User> list = criteria.list();
        System.out.println(list);
//        tr.commit();
        session.close();
    }

    /**
     * 按条件的查询,写法很麻烦
     */
    @Test
    public void run6() {
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        //先获取criteria接口
        Criteria criteria = session.createCriteria(User.class);
        //添加查询的条件, select * from t_user where age > 18;
        //Criterion 是Hibernate提供的条件查询的对象,想传入条件的使用的工具类

        //Restrictions提供的静态的方法,拼接查询的条件
        criteria.add(Restrictions.gt("age", 18));
        //断续添加条件
        criteria.add(Restrictions.like("name", "%小%"));
        List<User> list = criteria.list();
        System.out.println(list);
        tr.commit();
        session.close();
    }
}
