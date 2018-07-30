package com.itheima.a_response.b_body;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 操作响应体
 */
@WebServlet(name = "PrintServlet", urlPatterns = {"/print"})
public class PrintServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理响应的中文乱码
        //response.setContentType("text/html;charset=utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");

        //打印表格
        //获取字符流
        PrintWriter w = response.getWriter();
        w.print("<table border='1'><tr>");
        w.print("<td>用户名：</td>");
        w.print("<td>tom</td>");
        w.print("<tr><td>密码：</td>");
        w.print("<td>123</td>");
        w.print("</tr></table>");
    }
}
