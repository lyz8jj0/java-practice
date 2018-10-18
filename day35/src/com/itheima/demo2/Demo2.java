package com.itheima.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试IOC的程序
 */
public class Demo2 {

    /**
     * 原来的方式
     */
    @Test
    public void run1() {
        //创建实现类
        UserServiceImpl us = new UserServiceImpl();
        us.setName("美美");
//        UserService us = new UserServiceImpl();
        us.sayHello();
    }


    /**
     *使用的是Spring框架的方式
     */
    @Test
    public void run2(){
        //创建工厂,加载核心配置文件
        ApplicationContext ac  = new ClassPathXmlApplicationContext("applicationContext.xml");

        //从工厂中获取到对象
        UserServiceImpl usi = (UserServiceImpl) ac.getBean("userService");

        //调用对象的方法执行
        usi.sayHello();
    }


    /**
     *使用的是Spring框架的方式
     */
    @Test
    public void run3(){
        //创建工厂,加载核心配置文件
        ApplicationContext ac  = new ClassPathXmlApplicationContext("applicationContext.xml");

        //从工厂中获取到对象
        UserService usi = (UserService) ac.getBean("userService");

        //调用对象的方法执行
        usi.sayHello();
    }

    /**
     * 依赖注入
     */
    @Test
    public void run6(){
        //创建工厂,加载核心配置文件
        ApplicationContext ac  = new ClassPathXmlApplicationContext("applicationContext.xml");

        //从工厂中获取到对象
        UserService usi = (UserService) ac.getBean("userService");

        //调用对象的方法执行
        usi.sayHello();
    }
}
