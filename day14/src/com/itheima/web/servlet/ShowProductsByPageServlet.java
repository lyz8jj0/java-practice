package com.itheima.web.servlet;

import com.itheima.domain.PageBean;
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
 * 分页展示数据
 */
@WebServlet(name = "ShowProductsByPageServlet", urlPatterns = {"/showProductsByPage"})
public class ShowProductsByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0,设置编码

        //1,获取第几页
        int currPage = Integer.parseInt(request.getParameter("currPage"));
        //固定每页显示的条数
        int pageSize = 3;

        //2,调用service完成分页查询 返回值:pagebean
        PageBean<Product> bean = null;
        try {
            bean = new ProductService().showProductsByPage(currPage, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //3,将pagebean放入request域中,请求转发product_page.jsp
        request.setAttribute("pb", bean);
        request.getRequestDispatcher("/product_page.jsp").forward(request, response);
    }
}
