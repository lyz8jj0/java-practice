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
 * 查询所有的客户
 */
@WebServlet(name = "ListCustomerServlet", urlPatterns = {"/listCustomer"})
public class ListCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //先获取请求的参数
        request.setCharacterEncoding("UTF-8");
        //获取客户的名称
        String custName = request.getParameter("custName");

        List<Customer> list = new CustomerService().findAll(custName);
        //存入request
        request.setAttribute("list", list);
        //转发
        request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);

    }

}
