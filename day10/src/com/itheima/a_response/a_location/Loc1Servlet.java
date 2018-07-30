package com.itheima.a_response.a_location;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/7/30.
 */
@WebServlet(name = "Loc1Servlet", urlPatterns = {"/loc1"})
public class Loc1Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我说:没零钱~~~");

        System.out.println("又曰:找侯老师");

        //方式1:理解
        //设状态码 302
        //response.setStatus(302);

        //设置响应头
        //response.setHeader("location", "/day10/loc2");

        //方式2：掌握
        response.sendRedirect("/loc2");
    }
}
