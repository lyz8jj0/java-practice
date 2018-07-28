package com.itheima.servlet;

import com.itheima.domain.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/7/27.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0,设置编码
        response.setContentType("text/html;charset=utf-8");
        //1,接受用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2,调用userservice里的login(username,password) 返回值User user
        User user = null;
        try {
            user = new UserService().login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常，请稍后再试");
        }
        //3,判断user是否为空
        if (user == null) {
            //3.1 若为空写“用户名和密码不匹配”
            response.getWriter().print("用户名和密码不匹配,3s之后跳转");
            response.setHeader("refresh", "3;url=/day0901/login.html");
        } else {
            response.getWriter().print(user.getUsername() + "：欢迎回来");
        }
        //3.2 若不为空写“xxx：欢迎回来”

    }
}
