package com.itheima.service;

import com.itheima.dao.ProvinceDao;
import com.itheima.domain.Province;

import java.sql.SQLException;
import java.util.List;

public class ProvinceService {
    public List<Province> findAll() throws SQLException {
        return new ProvinceDao().findAll();
    }
}
