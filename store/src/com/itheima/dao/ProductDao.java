package com.itheima.dao;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findNew() throws Exception;

    List<Product> findHot() throws Exception;
}
