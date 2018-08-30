package com.itheima.service;

import com.itheima.dao.CityDao;
import com.itheima.domain.City;

import java.sql.SQLException;
import java.util.List;

public class CityService {
    /**
     * 通过省份id查询所有的市
     *
     * @param pid
     * @return
     */
    public List<City> findCitiesByPid(String pid) throws SQLException {
        return new CityDao().findCitiesByPid(pid);
    }
}
