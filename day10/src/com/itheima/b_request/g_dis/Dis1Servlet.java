package com.itheima.b_request.g_dis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/7/31.
 */
@WebServlet(name = "Dis1Servlet", urlPatterns = {"/dis1"})
public class Dis1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我说：稍等");

        //将借钱人的姓名放入request中
        request.setAttribute("username", "++");

        //请求转发
        request.getRequestDispatcher("/dis2").forward(request, response);
    }
}
