package com.itheima.dao;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CustomerDao {
    /**
     * 保存客户
     *
     * @param c
     */
    public void save(Customer c) {
        //先获取session
        Session session = HibernateUtils.getSession();
        //开启事务
        Transaction tr = session.beginTransaction();
        //保存用户
        session.save(c);
        //提交事务
        tr.commit();
        //关闭资源
        session.close();

    }

    /**
     * 查询所有的客户列表
     *
     * @return
     */
    public List<Customer> findAll() {
        //QBC查询
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        //创建查询的接口
//        Query query = session.createQuery("from Customer");
        Criteria criteria = session.createCriteria(Customer.class);
        //查询
        List<Customer> list = criteria.list();
        tr.commit();
        session.close();
        return list;
    }


    /**
     * 带查询条件的客户列表
     *
     * @return
     */
    public List<Customer> findAll(String custName) {
        //QBC查询
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        //创建查询的接口
//        Query query = session.createQuery("from Customer");
        Criteria criteria = session.createCriteria(Customer.class);
        //添加查询条件
        if (custName != null && !custName.trim().isEmpty()) {
            //添加查询条件
            criteria.add(Restrictions.like("cust_name", "%" + custName + "%"));
        }

        //查询
        List<Customer> list = criteria.list();
        tr.commit();
        session.close();
        return list;
    }
}
