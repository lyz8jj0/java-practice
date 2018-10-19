package com.itheima.dao;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    public Customer getCustomerList() {
        //获取session
        Session session = HibernateUtils.getSession();
        //创建查询的接口
        Query query = session.createQuery("from Customer");
        //查询所的数据select * from
        List<Customer> list = query.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }

        return null;
    }
}
