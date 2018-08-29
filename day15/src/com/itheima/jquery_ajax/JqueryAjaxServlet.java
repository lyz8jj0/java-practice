package com.itheima.jquery_ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jquery的ajax
 */
@WebServlet(name = "JqueryAjaxServlet", urlPatterns = {"/jqueryAjax"})
public class JqueryAjaxServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求的方式:" + request.getMethod());

        //接受参数
        String username = request.getParameter("username");
        System.out.println(username);

        //{"result":"success","msg":"成功"}
        String s = "{\"result\":\"success\",\"msg\":\"成功\"}";

        //响应数据
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(s);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求的方式:" + request.getMethod());

        //接受参数
        String username = request.getParameter("username");
        System.out.println(username);

        //响应数据
        response.getWriter().print("success");

    }
}
