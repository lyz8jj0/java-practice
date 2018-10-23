package com.itheima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hibernate框架的工具类
 */
public class HibernateUtils {
    private static final Configuration CONFIG;
    private static final SessionFactory FACTORY;

    //编写静态代码块
    static {
        //加载XML的配置文件
        CONFIG = new Configuration().configure();

        //构造工厂
        FACTORY = CONFIG.buildSessionFactory();
    }

    /**
     * 从工厂获取Session对象
     *
     * @return
     */
    public static Session getSession() {
        return FACTORY.openSession();
    }

    /**
     * 从ThreadLocal类中获取session的对象
     *
     * @return
     */
    public static Session getCurrentSession() {
        return FACTORY.getCurrentSession();
    }

    public static void main(String[] args) {
        //调用获取session方法
        getSession();
    }
}
