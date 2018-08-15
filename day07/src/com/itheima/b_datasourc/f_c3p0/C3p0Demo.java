package com.itheima.b_datasourc.f_c3p0;

import com.itheima.utils.JdbcUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class C3p0Demo {
    @Test
    //硬编码
    public void f1() throws PropertyVetoException, SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource();

        //设置参数
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/day07");
        ds.setUser("root");
        ds.setPassword("");

        Connection conn = ds.getConnection();
        String sql = "insert into category values(?,?)";
        PreparedStatement st = conn.prepareStatement(sql);

        //设置参数
        st.setString(1, "c012");
        st.setString(2, "毒药");

        int i = st.executeUpdate();
        System.out.println(i);
        JdbcUtils.closeResource(conn, st, null);
    }


    @Test
    public void f2() throws Exception {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        Connection conn = ds.getConnection();
        String sql = "insert into category values(?,?)";
        PreparedStatement st = conn.prepareStatement(sql);

        //设置参数
        st.setString(1, "c014");
        st.setString(2, "解药_");

        int i = st.executeUpdate();
        System.out.println(i);
        JdbcUtils.closeResource(conn, st, null);
    }

}
