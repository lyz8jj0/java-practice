package com.itheima.b_request.d_row;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 操作请求行
 */
@WebServlet(name = "RowServlet", urlPatterns = {"/row"})
public class RowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求方式
        String m = request.getMethod();
        System.out.println("方式：" + m);

        //获取请求资源
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        System.out.println("uri:" + uri);
        System.out.println("url:" + url);

        //获取请求参数的字符串
        String s = request.getQueryString();
        System.out.println("get请求参数：" + s);

        //获取协议版本
        String p = request.getProtocol();
        System.out.println("协议：" + p);

        System.out.println("--------重要-----------");

        //获取请求的ip
        String ip = request.getRemoteAddr();
        System.out.println("ip:" + ip);

        //获取项目名
        String path = request.getContextPath();
        System.out.println("项目路径：" + path);
    }
}
