package com.itheima.dao;

import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.util.List;

public class KeyWordDao {
    public List<Object> findKw4Ajax(String kw) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select kw from keyword where kw like ? limit 5";
        return qr.query(sql, new ColumnListHandler("kw"), "%" + kw + "%");
    }
}
