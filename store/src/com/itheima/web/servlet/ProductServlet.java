package com.itheima.web.servlet;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 商品servlet
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends BaseServlet {
    /**
     * 通过id查询单个商品详情
     *
     * @param request
     * @param response
     * @return
     */
    public String getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取商品的id
        String pid = request.getParameter("pid");

        //调用service
        ProductService ps = new ProductServiceImpl();
        Product p = ps.getByPid(pid);
        //将结果放入request中请求转发
        request.setAttribute("bean", p);
        return "/jsp/product_info.jsp";
    }
}
