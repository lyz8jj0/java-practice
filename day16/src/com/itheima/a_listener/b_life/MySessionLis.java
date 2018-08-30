package com.itheima.a_listener.b_life;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class MySessionLis implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
//        System.out.println("session 创建了...........");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
//        System.out.println("session销毁了.............");
    }
}
