package com.itheima.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户的JavaBean
 * 一方
 */
public class Customer {
    //以后使用包装类,默认值为null
    private Long cust_id;
    private String cust_name;
    private Long cust_user_id;
    private Long cust_create_id;

    private String cust_source;
    private String cust_industry;
    private String cust_level;
    private String cust_linkman;
    private String cust_phone;
    private String cust_mobile;

    //Hibernate框架默认的集合是set集合,集合必须要自己手动的初始化
    private Set<Linkman> linkmans = new HashSet<>();

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public Long getCust_user_id() {
        return cust_user_id;
    }

    public void setCust_user_id(Long cust_user_id) {
        this.cust_user_id = cust_user_id;
    }

    public Long getCust_create_id() {
        return cust_create_id;
    }

    public void setCust_create_id(Long cust_create_id) {
        this.cust_create_id = cust_create_id;
    }

    public String getCust_source() {
        return cust_source;
    }

    public void setCust_source(String cust_source) {
        this.cust_source = cust_source;
    }

    public String getCust_industry() {
        return cust_industry;
    }

    public void setCust_industry(String cust_industry) {
        this.cust_industry = cust_industry;
    }

    public String getCust_level() {
        return cust_level;
    }

    public void setCust_level(String cust_level) {
        this.cust_level = cust_level;
    }

    public String getCust_linkman() {
        return cust_linkman;
    }

    public void setCust_linkman(String cust_linkman) {
        this.cust_linkman = cust_linkman;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_mobile() {
        return cust_mobile;
    }

    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }

    public Set<Linkman> getLinkmans() {
        return linkmans;
    }

    public void setLinkmans(Set<Linkman> linkmans) {
        this.linkmans = linkmans;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_user_id=" + cust_user_id +
                ", cust_create_id=" + cust_create_id +
                ", cust_source='" + cust_source + '\'' +
                ", cust_industry='" + cust_industry + '\'' +
                ", cust_level='" + cust_level + '\'' +
                ", cust_linkman='" + cust_linkman + '\'' +
                ", cust_phone='" + cust_phone + '\'' +
                ", cust_mobile='" + cust_mobile + '\'' +
                '}';
    }
}
