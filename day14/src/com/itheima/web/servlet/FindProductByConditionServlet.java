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
import java.util.List;

/**
 * 多条件查询
 */
@WebServlet(name = "FindProductByConditionServlet", urlPatterns = {"/findProductByCondition"})
public class FindProductByConditionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0,设置编码
        request.setCharacterEncoding("utf-8");

        //1,接收两个参数
        String name = request.getParameter("name");
        String kw = request.getParameter("kw");

        //2,调用service完成操作 返回值:list
        List<Product> plist = null;
        try {
            plist = new ProductService().findProductByCondition(name, kw);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //3,将list放入request域中,请求转发
        request.setAttribute("list", plist);
        request.getRequestDispatcher("/product_list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
