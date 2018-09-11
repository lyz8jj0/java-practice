package com.itheima.service.impl;

import com.itheima.dao.ProductDao;
import com.itheima.dao.impl.ProductDaoImpl;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    /**
     * 查询最新
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findNew() throws Exception {
        ProductDao pdao = new ProductDaoImpl();
        return pdao.findNew();
    }

    /**
     * 查询热门
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findHot() throws Exception {
        ProductDao pdao = new ProductDaoImpl();
        return pdao.findHot();
    }

    /**
     * 查询单个商品
     *
     * @return
     * @throws Exception
     */
    @Override
    public Product getByPid(String pid) throws Exception {
        ProductDao pdao = new ProductDaoImpl();
        return pdao.getByPid(pid);
    }
}
