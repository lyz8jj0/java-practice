package com.itheima.test;

import com.itheima.domain.Linkman;
import com.itheima.utils.HibernateUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * SQL的查询方式
 */
public class Demo4 {
    /**
     * 测试SQL语句的查询
     */
    @Test
    public void run1() {
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        //创建的是SQL的查询接口
        SQLQuery query = session.createSQLQuery("select * FROM cst_linkman");
        //查询数据
        List<Object[]> list = query.list();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
        tr.commit();
    }


    /**
     * 把数据封装到对象中
     */
    @Test
    public void run2() {
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();
        //创建的是SQL的查询接口
        SQLQuery query = session.createSQLQuery("select * FROM cst_linkman");
        //通过方法设置
        query.addEntity(Linkman.class);
        List<Linkman> list = query.list();
        for (Linkman linkman : list) {
            System.out.println(linkman);
        }
        tr.commit();
    }


}
