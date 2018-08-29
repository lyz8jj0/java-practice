package com.itheima.web.servlet;

import com.itheima.service.KeyWordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchKwServlet", urlPatterns = {"/searchKw"})
public class SearchKwServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0,设置编码
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //1,获取kw
        String kw = request.getParameter("kw");

        //2,调用service完成模糊操作 返回值:list
        List<Object> list = null;
        try {
            list = new KeyWordService().findKw4Ajax(kw);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //3,将数据[a,aa,aaa]去掉
        if (list != null && list.size() > 0) {
            String s = list.toString();
            s = s.substring(1, s.length() - 1);
            response.getWriter().println(s);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
