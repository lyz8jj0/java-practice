package com.itheima.a_cookie.a_hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2018/8/1.
 */
@WebServlet(name = "HelloCookieServlet",urlPatterns = {"/hello"})
public class HelloCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter w = response.getWriter();

        //创建一个cookie
        Cookie a = new Cookie("akey","avalue");


        //写回浏览器
        response.addCookie(a);

        //提示信息
        w.print("cookie 已写回");
    }
}
