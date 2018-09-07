package com.itheima.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IndexServlet", urlPatterns = {"/index"})
public class IndexServlet extends BaseServlet {
    @Override
    public String index(HttpServletRequest request, HttpServletResponse response) {
        //去数据库中查询最新商品和热闹商品 将他们放入request域中 请求转发
        return "/jsp/index.jsp";
    }


}
