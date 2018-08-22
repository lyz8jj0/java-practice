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

    /**
     * 通过id查找商品
     *
     * @param pid
     * @return
     */
    public Product getProductById(String pid) throws SQLException {
        return new ProductDao().getProductById(pid);
    }

    /**
     * 修改商品
     *
     * @param p
     */
    public void updateProduct(Product p) throws SQLException {
        new ProductDao().updateProductById(p);
    }

    /**
     * 通过pid删除商品
     *
     * @param pid
     */
    public void deleteProductById(String pid) throws SQLException {
        new ProductDao().deleteProductById(pid);
    }
}
