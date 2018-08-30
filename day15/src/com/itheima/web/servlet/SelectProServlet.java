package com.itheima.web.servlet;

import com.itheima.domain.Province;
import com.itheima.service.ProvinceService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 查询所有的省
 */
@WebServlet(name = "SelectProServlet", urlPatterns = {"/selectPro"})
public class SelectProServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1,调用service 查询所的省份
        List<Province> list = null;
        try {
            list = new ProvinceService().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //2,将所有省份写回去
        response.setContentType("text/html;charset=utf-8");
        if (list != null && list.size() > 0) {
            response.getWriter().println(JSONArray.fromObject(list));
        }
    }
}
