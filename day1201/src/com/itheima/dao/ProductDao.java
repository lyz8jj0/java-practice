package com.itheima.dao;

import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    public List<Product> findAll() throws SQLException {
        //创建queryrunner
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

        //编写sql
        String sql = "select * from product";

        //执行sql
        List<Product> result = qr.query(sql, new BeanListHandler<>(Product.class));

        return result;
    }
}
