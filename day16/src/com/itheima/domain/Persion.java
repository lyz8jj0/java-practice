package com.itheima.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Persion implements HttpSessionBindingListener {
    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Persion() {
    }

    public Persion(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    //绑定到了session中
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("Persion对象绑定到了session中");
    }

    @Override
    //从session中移除
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("Persion对象从session中移除了~~~");
    }
}
