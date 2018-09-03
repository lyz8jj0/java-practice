package com.itheima.web.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContexLis implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("servletcontext 创建了~~~~~");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
