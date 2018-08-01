package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 清空购物车
 */
@WebServlet(name = "ClearCartServlet", urlPatterns = {"/clearCart"})
public class ClearCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1，清空session
        request.getSession().invalidate();

        //2，重写向
        response.sendRedirect(request.getContextPath() + "/cart.jsp");
    }
}
