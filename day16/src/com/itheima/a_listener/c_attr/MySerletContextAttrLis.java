package com.itheima.a_listener.c_attr;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MySerletContextAttrLis implements ServletContextAttributeListener {
    @Override
    //添加
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
//        System.out.println("servletContext中添加一个属性,属性为:"+servletContextAttributeEvent.getName());
    }

    @Override
    //删除
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
//        System.out.println("servletContext中移除一个属性,属性为:"+servletContextAttributeEvent.getName());

    }

    @Override
    //替换
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
//        System.out.println("servletContext中替换一个属性,属性为:"+servletContextAttributeEvent.getName());
    }
}
