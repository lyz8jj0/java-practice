package com.itheima.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/7/28.
 */
@WebServlet(name = "ShowServlet", urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0,设置编码
        response.setContentType("text/html;charset=utf-8");

        //1,获取全局管理者
        ServletContext context = this.getServletContext();

        //2,获取登录的次数
        Integer cishu = (Integer) context.getAttribute("count");

        //3,在页面上打印总次数
        response.getWriter().print("登录成功的总次数：" + cishu);
    }
}
