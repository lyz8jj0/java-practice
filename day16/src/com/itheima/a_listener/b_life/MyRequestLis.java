package com.itheima.a_listener.b_life;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class MyRequestLis implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
//        System.out.println("请求已销毁~~~");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
//        System.out.println("请求创建了~~~");
    }
}
