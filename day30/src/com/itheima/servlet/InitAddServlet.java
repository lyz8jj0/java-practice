package com.itheima.servlet;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 初始化添加联系人的页面
 */
@WebServlet(name = "InitAddServlet",urlPatterns = {"/initAdd"})
public class InitAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询所有的客户
        List<Customer> list = new CustomerService().findAll();
        //保存request
        request.setAttribute("list",list);
        request.getRequestDispatcher("/jsp/linkman/add.jsp").forward(request,response);
    }
}
