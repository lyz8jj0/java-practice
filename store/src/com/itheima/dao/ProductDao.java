package com.itheima.dao;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findNew() throws Exception;

    List<Product> findHot() throws Exception;

    Product getByPid(String pid) throws Exception;

    List<Product> findByPage(int currPage, int pageSize, String cid) throws Exception;

    int getTotalCount(String cid) throws Exception;

    void updateCid(String cid) throws Exception;

    List<Product> findAll() throws Exception;

    void add(Product p) throws Exception;
}
