package com.itheima.dao;

import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
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

    /**
     * 多条件查询
     *
     * @param name 商品名称
     * @param kw   关键词
     * @return list
     */
    public List<Product> findProductByCondition(String name, String kw) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where 1=1 ";
        ArrayList<String> params = new ArrayList<>();
        if (name != null && name.trim().length() > 0) {
            sql += ("and pname like ? ");
            params.add("%" + name + "%");
        }
        if (kw != null && kw.trim().length() > 0) {
            sql += ("and pdesc like ? ");
            params.add("%" + kw + "%");
        }
        return qr.query(sql, new BeanListHandler<>(Product.class), params.toArray());

    }

    /**
     * 查询第几页的数据
     *
     * @param currPage
     * @param pageSize
     * @return
     */
    public List<Product> findProductByPage(int currPage, int pageSize) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product limit ?,?";
        return qr.query(sql, new BeanListHandler<>(Product.class), (currPage - 1) * pageSize, pageSize);
    }

    /**
     * 查询总条数
     *
     * @return
     */
    public int getCount() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from product";
        return ((Long) qr.query(sql, new ScalarHandler())).intValue(); 
    }
}
