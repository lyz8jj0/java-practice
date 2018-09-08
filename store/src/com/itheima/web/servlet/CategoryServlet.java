package com.itheima.web.servlet;

import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import com.itheima.service.impl.CategoryServiceImpl;
import com.itheima.utils.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet",urlPatterns = {"/category"})
public class CategoryServlet extends BaseServlet {
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1,调用categoryService查询所有的分类返回值list
        CategoryService cs = new CategoryServiceImpl();
        List<Category> clist = null;
        try {
            clist = cs.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2,将返回值放入request域中
        //request.setAttribute("clist", clist);
        String json = JsonUtil.list2json(clist);

        //3,写回页面
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(json);

        return null;

    }


}
