package com.itheima.web.servlet;

import com.itheima.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 删除多个商品
 */
@WebServlet(name = "DelCheckedServlet",urlPatterns = {"/delCheckedServlet"})
public class DelCheckedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1,获取商品
        String[] ids = request.getParameterValues("pid");

        //2,调用service完成删除多个
        try {
            new ProductService().deleteManyProduct(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //3,页面重定向
        response.sendRedirect(request.getContextPath()+"/findAll");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
