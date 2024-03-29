package com.itheima.test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;


/**
 * 测试Hibernate框架
 */
public class Demo1 {
    /**
     * 测试保存客户
     */
    @Test
    public void testSave() {
        /**
         * 1,先加载配置文件
         * 2,创建SessionFactory对象,生成Session对象
         * 3,创建session对象
         * 4,开启事务
         * 5,编写保存的代码
         * 6,提交事务
         * 7,释放资源
         */
        //1,先加载配置文件
        //Configuration config = new Configuration();
        //默认加载src目录下hibernate.cfg.xml配置文件
        //config.configure();

        //简写的方法
        Configuration config = new Configuration().configure();

        //2,创建SessionFactory对象,生成Session对象
        SessionFactory factory = config.buildSessionFactory();
        //3,创建session对象
        Session session = factory.openSession();
        //4,开启事务
        Transaction tr = session.beginTransaction();

        //5,编写保存的代码
        Customer c = new Customer();
        //c.setCust_id(cust_id) 主键自动递增了
        c.setCust_name("测试2");
        c.setCust_level("2");
        c.setCust_phone("110");

        //保存数据,操作对象就相当于操作数据库的表结构
        session.save(c);

        //6,提交事务
        tr.commit();
        //7,释放资源
        session.close();
        factory.close();
    }

    @Test
    public void testSave2() {
        //原来:加载配置文件,获取Factory对象,获取session
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        Customer c = new Customer();
        c.setCust_name("小风");
        session.save(c);
        //提交事务
        tr.commit();
        //释放资源
        session.close();
    }

    /**
     * 测试get()方法,获取查询,通过主键来查询一条记录
     */
    @Test
    public void testGet() {
        //原来:加载配置文件,获取Factory对象,获取session
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();

        //测试查询的方法2个参数:arg0查询JavaBean的class对象 arg1主键的值
        Customer c = session.get(Customer.class, 97L);
        System.out.println(c);

        //提交事务
        tr.commit();
        //释放资源
        session.close();
    }

    /**
     * 测试删除方法
     * 注意:删除或者修改,先查询再删除或修改
     */
    @Test
    public void testDel() {
        //原来:加载配置文件,获取Factory对象,获取session
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();

        //测试查询的方法2个参数:arg0查询JavaBean的class对象 arg1主键的值
        Customer c = session.get(Customer.class, 97L);

        //删除客户
        session.delete(c);

        //提交事务
        tr.commit();
        //释放资源
        session.close();
    }

    /**
     * 测试修改
     */
    @Test
    public void testUpdate() {
        //原来:加载配置文件,获取Factory对象,获取session
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();

        //测试查询的方法2个参数:arg0查询JavaBean的class对象 arg1主键的值
        Customer c = session.get(Customer.class, 96L);

        //设置客户的信息
        c.setCust_name("小苍");
        c.setCust_level("3");

        //修改
        session.update(c);

        //提交事务
        tr.commit();
        //释放资源
        session.close();
    }

    /**
     * 测试修改
     */
    @Test
    public void testSaveOrUpdate() {
        //原来:加载配置文件,获取Factory对象,获取session
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();

        //测试查询的方法2个参数:arg0查询JavaBean的class对象 arg1主键的值
        Customer c = session.get(Customer.class, 9L);
        c.setCust_name("小泽");

        //修改
        session.saveOrUpdate(c);

        //提交事务
        tr.commit();
        //释放资源
        session.close();
    }


    @Test
    public void testSel() {
        //原来:加载配置文件,获取Factory对象,获取session
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();

        //创建查询的接口
        Query query = session.createQuery("from Customer");
        //查询所有的数据select * from 表
        List<Customer> list = query.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }

        //提交事务
        tr.commit();
        //释放资源
        session.close();
    }

    @Test
    public void testSave3() {
        Session session = null;
        Transaction tr = null;
        try {
            //获取session
            session = HibernateUtils.getSession();
            //开启事务
            tr = session.beginTransaction();
            //执行代码
            Customer c = new Customer();
            c.setCust_name("哈哈");
            //保存
            session.save(c);
            //提交事务
            tr.commit();
        } catch (Exception e) {
            //回滚
            tr.rollback();
            e.printStackTrace();
        } finally {
            //释放资源
            session.close();
        }
    }
}
