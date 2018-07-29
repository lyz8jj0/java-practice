package com.itheima.d_config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "SConfigServlet", urlPatterns = {"/scontext"})
public class SConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1,获取全局管理者
        ServletContext context = this.getServletContext();

        //获取初始化参数
        String encoding = context.getInitParameter("encoding");
        System.out.println("初始化参数：" + encoding);

        //获取文件的真实路径
        String path = context.getRealPath("/");
        System.out.println(path);

        //以流的形式返回一个文件
        InputStream is = context.getResourceAsStream("/1.txt");
        System.out.println(is);

        //获取文件的mine类型
        System.out.println("----------------");
        String mimeType = context.getMimeType("1.jpg");
        System.out.println(mimeType);
    }
}
