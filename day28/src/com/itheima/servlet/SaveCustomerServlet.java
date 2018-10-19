package com.itheima.servlet;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class SaveCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收请求的数据
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> map = request.getParameterMap();
        //封装数据,使用BeanUtils工具,导入jar包
        Customer c = new Customer();
        try {
            //封装数据
            BeanUtils.populate(c, map);
            //调用业务层
            new CustomerService().saveCustomer(c);
            System.out.println("添加客户成功了...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
