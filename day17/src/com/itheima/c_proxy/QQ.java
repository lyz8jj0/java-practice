package com.itheima.c_proxy;

public class QQ implements Car {
    @Override
    public void run() {
        System.out.println("qq在跑");
    }

    @Override
    public void stop() {
        System.out.println("qq刹车");
    }
}
