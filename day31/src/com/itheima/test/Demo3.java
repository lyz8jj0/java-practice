package com.itheima.test;

import com.itheima.domain.Customer;
import com.itheima.domain.Linkman;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * QBC查询
 */
public class Demo3 {
    /**
     * QBC的基本入门查询
     */
    @Test
    public void run1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Customer.class);
        List<Customer> list = criteria.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        tr.commit();
    }


    /**
     * 排序查询,调用的方法
     */
    @Test
    public void run2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Linkman.class);

        //调用排序的方法,addOrder()
        criteria.addOrder(Order.desc("lkm_id"));

        List<Linkman> list = criteria.list();
        for (Linkman linkman : list) {
            System.out.println(linkman);
        }
        tr.commit();
    }


    /**
     * QBC分页的方法和HQL分页的方式一样
     */
    @Test
    public void run3() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Linkman.class);

        //调用排序的方法,addOrder()
        criteria.addOrder(Order.desc("lkm_id"));

        //设置分页的方法
        criteria.setFirstResult(0);
        criteria.setMaxResults(3);

        List<Linkman> list = criteria.list();
        for (Linkman linkman : list) {
            System.out.println(linkman);
        }
        tr.commit();
    }

    /**
     * QBC的条件查询
     */
    @Test
    public void run4() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Linkman.class);

        //使用方法添加条件 and
        //criteria.add(Restrictions.eq("lkm_gender","男"));
        //criteria.add(Restrictions.ge("lkm_id",3L));
        //在之间
        //criteria.add(Restrictions.between("lkm_id", 2L, 5L));

        List<Linkman> list = criteria.list();
        for (Linkman linkman : list) {
            System.out.println(linkman);
        }
        tr.commit();
    }

    /**
     * in查询
     */
    @Test
    public void run5() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Linkman.class);

        //SQL:select * from cst_linkman where lkm_id in (1,2,7);
        List<Long> params = new ArrayList<Long>();
        params.add(1L);
        params.add(2L);
        params.add(7L);

        //使用in方法查询
        criteria.add(Restrictions.in("lkm_id", params));

        List<Linkman> list = criteria.list();
        for (Linkman linkman : list) {
            System.out.println(linkman);
        }
        tr.commit();
    }


    /**
     * or查询
     */
    @Test
    public void run6() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Linkman.class);

        //SQL: select * from cst_linkman where lkm_gender = '女' or lkm_id > 3L;
        criteria.add(Restrictions.or(Restrictions.eq("lkm_gender", "女"), Restrictions.ge("lkm_id", 3L)));

        List<Linkman> list = criteria.list();
        for (Linkman linkman : list) {
            System.out.println(linkman);
        }
        tr.commit();
    }



    /**
     * 判断值是否为空
     */
    @Test
    public void run7() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Linkman.class);

        //找所有lkm_email是空的值
        criteria.add(Restrictions.isNull("lkm_email"));

        List<Linkman> list = criteria.list();
        for (Linkman linkman : list) {
            System.out.println(linkman);
        }
        tr.commit();
    }
}
