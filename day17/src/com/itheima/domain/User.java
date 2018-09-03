package com.itheima.domain;

import com.itheima.myenum.Color;

import java.util.Date;
import java.util.List;

public class User {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @SuppressWarnings("all")
    private String username;

    @SuppressWarnings("all")
    private List list;

    @SuppressWarnings("all")
    public static void main(String[] args) {
        new Date().toLocaleString();
        add();
    }


    @Deprecated
    private static void add() {

    }

    public static void add(int... args) {

    }

    private Color RED;
}
