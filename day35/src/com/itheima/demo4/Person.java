package com.itheima.demo4;

public class Person {
    private String pname;
    private Car1 car1;

    public Person(String pname, Car1 car1) {
        this.pname = pname;
        this.car1 = car1;
    }

    @Override
    public String toString() {
        return "Person[" +
                "name='" + pname + '\'' +
                ", car1=" + car1 +
                ']';
    }
}
