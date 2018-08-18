package com.itheima.c_dbuits.g_curd;

import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

public class CURDDemo {

    @Test
    public void insert() throws SQLException {
        //1,创建queryrunner类
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

        //2,编写sql
        String sql = "insert into category values(?,?)";

        //3,执行sql
        qr.update(sql, "c201", "厨房电器");
    }

}
