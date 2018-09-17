package com.itheima.domain;

import com.itheima.domain.Order.Order;

public class OrderItem {
    private String itemid;
    private Integer count;
    private Double subtotal;

    //包含的哪个商品
    private Product product;

    //属于哪个订单
    private Order order;
}
