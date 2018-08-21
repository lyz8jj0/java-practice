package com.itheima.dao;

import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    /**
     * 查询所有商品
     *
     * @return
     */
    public List<Product> findAll() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product";
        return qr.query(sql, new BeanListHandler<>(Product.class));

    }

    /**
     * 添加商品
     *
     * @param p
     * @return
     */
    public void addProduct(Product p) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into product(pid,pname,market_price,shop_price,pdate,pdesc) values(?,?,?,?,?,?) ";
        qr.update(sql, p.getPid(), p.getPname(), p.getMarket_price(),
                p.getShop_price(), p.getPdate(), p.getPdesc());
    }
}
