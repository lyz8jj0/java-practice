package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/7/31.
 */
@WebServlet(name = "MsgServlet", urlPatterns = {"/msg"})
public class MsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0，设置编码
        response.setContentType("text/html;charset=utf-8");

        //1，从requst域中获取内容msg
        String s = (String) request.getAttribute("msg");

        //2,将信息打印到页面上
        response.getWriter().print(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
