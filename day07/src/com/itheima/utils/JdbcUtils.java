package com.itheima.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class JdbcUtils {
    static final String DRIVERCLASS;
    static final String URL;
    static final String USER;
    static final String PASSWORD;

    static { //只获取一次配置文件
        //获取ResourceBundle
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        //获取指定的内容
        DRIVERCLASS = bundle.getString("driverClass");
        URL = bundle.getString("url");
        USER = bundle.getString("user");
        PASSWORD = bundle.getString("password");

    }

    static {//注册驱动
        try {
            Class.forName(DRIVERCLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * 释放资源
     *
     * @param conn 连接
     * @param st   语句执行者
     * @param rs   结果集
     */
    public static void closeResource(Connection conn, Statement st, ResultSet rs) {
        closeResultSet(rs);
        closeStatement(st);
        closeConn(conn);
    }

    /**
     * 释放连接
     *
     * @param conn 连接
     */
    public static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    /**
     * 释放语句执行者
     *
     * @param st 语句执行者
     */
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            st = null;
        }
    }

    /**
     * 释放结果集
     *
     * @param rs 结果集
     */
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
    }
}
