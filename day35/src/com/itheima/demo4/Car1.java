package com.itheima.demo4;

public class Car1 {
    private String cname;
    private Double pirce;

    public Car1(String cname, Double pirce) {
        this.cname = cname;
        this.pirce = pirce;
    }

    @Override
    public String toString() {
        return "Car1[" +
                "cname='" + cname + '\'' +
                ", pirce=" + pirce +
                ']';
    }
}
