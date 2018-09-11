package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findNew() throws Exception;

    List<Product> findHot() throws Exception;

    Product getByPid(String pid) throws Exception;
}
