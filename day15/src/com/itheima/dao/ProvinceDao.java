package com.itheima.dao;

import com.itheima.domain.Province;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProvinceDao {
    public List<Province> findAll() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from province";
        return qr.query(sql,new BeanListHandler<>(Province.class));
    }
}
