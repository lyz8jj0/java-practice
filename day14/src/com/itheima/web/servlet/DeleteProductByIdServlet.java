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
 * 通过商品id删除商品
 */
@WebServlet(name = "DeleteProductByIdServlet", urlPatterns = {"/deleteProductById"})
public class DeleteProductByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1,获取商品id
        String pid = request.getParameter("pid");

        //2,调用service完成删除操作
        try {
            new ProductService().deleteProductById(pid);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("msg", "删除商品失败");
            request.getRequestDispatcher("/msg.jsp").forward(request, response);
            return;
        }

        //3,重写向FindAllServlelt
        response.sendRedirect(request.getContextPath() + "/findAll");
    }
}
