package com.itheima.domain;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class Persion2 implements HttpSessionActivationListener, Serializable {
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

    public Persion2() {
    }

    public Persion2(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    //钝化
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("Person对象写入磁盘(钝化)");
    }

    @Override
    //活化
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("Person对象活化了(活化)");
    }
}
