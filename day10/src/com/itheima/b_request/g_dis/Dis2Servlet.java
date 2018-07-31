package com.itheima.b_request.g_dis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 侯老师
 */
@WebServlet(name = "Dis2Servlet", urlPatterns = {"/dis2"})
public class Dis2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("侯老师问：需要多少？我答：" + request.getParameter("money"));
        System.out.println("侯老师以问：干嘛用啊？我答：借给" + request.getAttribute("username"));
    }
}
