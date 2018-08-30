package com.itheima.dao;

import com.itheima.domain.City;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CityDao {
    public List<City> findCitiesByPid(String pid) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from city where provinceid = ?";
        return qr.query(sql, new BeanListHandler<>(City.class), pid);
    }
}
