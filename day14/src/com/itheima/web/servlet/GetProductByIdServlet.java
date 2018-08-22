package com.itheima.web.servlet;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 通过商品id获取商品
 */
@WebServlet(name = "GetProductByIdServlet", urlPatterns = {"/getProductById"})
public class GetProductByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0,设置编码

        //1,获取商品
        String pid = request.getParameter("pid");

        //2,调用service 通过id获取商品 返回值product
        Product p = null;
        try {
            p = new ProductService().getProductById(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //3,将product放入request域中,请求转发到edit.jsp
        request.setAttribute("bean", p);
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }
}
