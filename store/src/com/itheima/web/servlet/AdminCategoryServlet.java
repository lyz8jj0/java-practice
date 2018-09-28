package com.itheima.web.servlet;

import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import com.itheima.utils.BeanFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 后台分类管理
 */
@WebServlet(name = "AdminCategoryServlet", urlPatterns = {"/adminCategory"})
public class AdminCategoryServlet extends BaseServlet {
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1,调用categoryservice查询所的分类信息 返回值list
        CategoryService cs = (CategoryService) BeanFactory.getBean("CategoryService");
        List<Category> list = cs.findAll();

        //2,将list放入request域中 请求转发即可
        request.setAttribute("list",list);
        return "/admin/category/list.jsp";
    }
}
