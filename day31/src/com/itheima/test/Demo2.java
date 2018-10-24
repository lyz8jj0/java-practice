package com.itheima.test;

import com.itheima.domain.Customer;
import com.itheima.domain.Linkman;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

/**
 * 演示HQL的基本查询
 */
public class Demo2 {
    /**
     * 基本演示
     */
    @Test
    public void run1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL的查询接口
        Query query = session.createQuery("from Customer ");
        //调用list()方法,查询
        List<Customer> list = query.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        tr.commit();
    }


    /**
     * 支持方法链的编写风格
     */
    @Test
    public void run2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL的查询接口
        List<Customer> list = session.createQuery("from Customer ").list();
        for (Customer customer : list) {
            System.out.println(list);
        }
        tr.commit();
    }


    /**
     * 是有别名的方式
     */
    @Test
    public void run3() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL的查询接口
        List<Customer> list = session.createQuery("select c from Customer c ").list();
        for (Customer customer : list) {
            System.out.println(list);
        }
        tr.commit();
    }

    /**
     * 排序查询
     * SQL:order by 字段asc/desc
     * HQL:关键字是一样的,都有order by 属性
     */
    @Test
    public void run4() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        List<Linkman> list = session.createQuery("from Linkman l order by l.lkm_id asc").list();
        for (Linkman linkman : list) {
            System.out.println(linkman);
        }
        tr.commit();
    }

    /**
     * HQL分页查询的两个方法
     * setFirstResult(a)    --从哪条记录开始,如果查询是从第一条开始,就是0
     * setMaxResults(b)     --每页查询的记录条数
     */
    @Test
    public void run5() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL的查询接口
        Query query = session.createQuery("from Linkman l order by l.lkm_id  ");

        //分页查询,调用方法,查询第一页的数据1-3条
        /*query.setFirstResult(0);
        query.setMaxResults(3);*/

        //查询第二页的数据query.setFirstResult(3); (当前页-1)*pageSize=3
        query.setFirstResult(3);
        query.setMaxResults(3);

        List<Linkman> list = query.list();

        for (Linkman linkman : list) {
            System.out.println(linkman);
        }
        tr.commit();
    }

    /**
     * 按条件进行查询
     */
    @Test
    public void run6() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL的查询接口
        Query query = session.createQuery("from Linkman l where l.lkm_id > ?");

        //传入
        //query.setString(0,"男");

        //query.setString("gender","女");

        //通用的方法,就不用再判断具体类型了
        query.setParameter(0,3L);

        List<Linkman> list = query.list();

        for (Linkman linkman : list) {
            System.out.println(linkman);
        }
        tr.commit();
    }
}
