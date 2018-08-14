package com.itheima.a_jdbc.a_hello;

import com.itheima.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Hello {
    @Test
    public void f1() {
        System.out.println("hello");
    }

    @Test
    public void f2() throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day07", "root", "");

        //编写sql
        String sql = "select * from category";

        //创建语句执行者
        PreparedStatement st = conn.prepareStatement(sql);

        //设置参数

        //执行sql
        ResultSet rs = st.executeQuery();

        //处理结果
        while (rs.next()) {
            System.out.println(rs.getString("cid") + "::" + rs.getString("cname"));
        }

        //释放资源
        rs.close();
        st.close();
        conn.close();
    }

    //插入一条数据
    @Test
    public void f3() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        //获取连接
        try {
            conn = JdbcUtils.getConnection();

            //编写sql
            String sql = "insert into category values(?,?)";

            //获取语句执行者
            st = conn.prepareStatement(sql);

            //设置参数
            st.setString(1, "c006");
            st.setString(2, "户外2");

            //执行sql
            int i = st.executeUpdate();

            //处理结果
            if (i == 1) {
                System.out.println("success");
            } else {
                System.out.println("error");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

}

