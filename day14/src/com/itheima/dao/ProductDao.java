package com.itheima.dao;

import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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

    /**
     * 通过商品id获取商品
     *
     * @param pid 商品id
     * @return 商品
     */
    public Product getProductById(String pid) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where pid = ?";
        return qr.query(sql, new BeanHandler<>(Product.class), pid);
    }

    /**
     * 修改商品
     *
     * @param p
     */
    public void updateProductById(Product p) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "update product set pname = ? ,market_price = ?,shop_price = ?,pdesc = ? where pid = ?";

        qr.update(sql, p.getPname(), p.getMarket_price(), p.getShop_price(),
                p.getPdesc(), p.getPid());


    }

    /**
     * 删除商品
     *
     * @param pid
     */
    public void deleteProductById(String pid) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from product where pid = ?";
        qr.update(sql, pid);

    }
}
