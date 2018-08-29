package com.itheima.service;

import com.itheima.dao.KeyWordDao;

import java.sql.SQLException;
import java.util.List;

public class KeyWordService {

    public List<Object> findKw4Ajax(String kw) throws SQLException {
        return new KeyWordDao().findKw4Ajax(kw);
    }
}
