package com.itheima.service;

import com.itheima.domain.Order;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;

import java.util.List;

public interface OrderService {
    void add(Order order) throws Exception;

    PageBean<Order> findAllByPage(int currPage, int pageSize, User user) throws Exception;

    Order getById(String oid) throws Exception;

    List<Order> findAllByState(String state) throws Exception;

    void update(Order order) throws Exception;
}
