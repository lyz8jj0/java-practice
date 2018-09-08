package com.itheima.web.servlet;

import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import com.itheima.service.impl.CategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = {"/index"})
public class IndexServlet extends BaseServlet {
    @Override
    public String index(HttpServletRequest request, HttpServletResponse response) {
//        //1,调用categoryService查询所有的分类返回值list
//        CategoryService cs = new CategoryServiceImpl();
//        List<Category> clist = null;
//        try {
//            clist = cs.findAll();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //2,将返回值放入request域中
//        request.setAttribute("clist", clist);

        //去数据库中查询最新商品和热闹商品 将他们放入request域中 请求转发
        return "/jsp/index.jsp";
    }


}
