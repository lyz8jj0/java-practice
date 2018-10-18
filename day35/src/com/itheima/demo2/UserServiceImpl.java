package com.itheima.demo2;

public class UserServiceImpl implements UserService {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello Spring!!!" + name);

    }
}
