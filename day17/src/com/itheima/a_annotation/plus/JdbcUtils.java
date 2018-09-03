package com.itheima.a_annotation.plus;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
    @JdbcInfo(url = "jdbc:mysql://localhost:3306/day16", password = "123")
    public static Connection getConnection() throws Exception {
        //1,获取字节码文件
        Class clazz = JdbcUtils.class;

        //2,获取getConnection
        Method m = clazz.getMethod("getConnection");

        //3,判断方法上是否有jdbcinfo注解 若有的话获取
        if (m.isAnnotationPresent(JdbcInfo.class)) {
            JdbcInfo info = m.getAnnotation(JdbcInfo.class);

            //4,获取注解四个属性
            String driverClass = info.driverClass();
            String url = info.url();
            String user = info.user();
            String password = info.password();

            //5,注册驱动
            Class.forName(driverClass);

            //6,获取连接
            return DriverManager.getConnection(url, user, password);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getConnection());
    }
}
