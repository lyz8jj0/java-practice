package com.itheima.web.servlet;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * 修改商品
 */
@WebServlet(name = "EditServlet", urlPatterns = {"/editProduct"})
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0,设置编码
        request.setCharacterEncoding("utf-8");

        //1,封装数据
        Product p = new Product();
        try {
            BeanUtils.populate(p, request.getParameterMap());

            //2,调用service完成更新
            new ProductService().updateProduct(p);

            //3,重写向FindAllServlet
            response.sendRedirect(request.getContextPath() + "/findAll");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "修改商品出错");
            request.getRequestDispatcher("/msg.jsp").forward(request, response);
        }
    }
}
