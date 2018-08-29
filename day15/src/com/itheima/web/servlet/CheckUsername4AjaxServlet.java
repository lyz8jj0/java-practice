package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CheckUsername4AjaxServlet", urlPatterns = {"/checkUsername4Ajax"})
public class CheckUsername4AjaxServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0,设置编码
        request.setCharacterEncoding("utf-8");

        //接收参数
        String username = request.getParameter("username");

        //调用service 完成查询 返回user
        User user = null;
        try {
            user = new UserService().checkUsername4Ajax(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //判断user 写回信息
        if (user == null) {
            response.getWriter().println("1");
        } else {
            response.getWriter().println("0");
        }

    }
}
