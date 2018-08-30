package com.itheima.a_listener.a_hello_servletcontext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class MyServletContextLis implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public MyServletContextLis() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //创建操作
//        System.out.println("servletContext创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //销毁操作
//        System.out.println("servletContext销毁了");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }


    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
    }
}
