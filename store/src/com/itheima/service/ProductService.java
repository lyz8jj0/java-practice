package com.itheima.service;

import com.itheima.domain.Product;
import com.itheima.domain.PageBean;

import java.util.List;

public interface ProductService {
    List<Product> findNew() throws Exception;

    List<Product> findHot() throws Exception;

    Product getByPid(String pid) throws Exception;

    PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception;
}
