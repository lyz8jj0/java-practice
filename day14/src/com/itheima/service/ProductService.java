package com.itheima.service;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    /**
     * 查询所有商品
     *
     * @return
     */
    public List<Product> findAll() throws SQLException {
        return new ProductDao().findAll();

    }

    /**
     * 添加商品
     *
     * @param p
     */
    public void addPorduct(Product p) throws SQLException {
        new ProductDao().addProduct(p);
    }
}
