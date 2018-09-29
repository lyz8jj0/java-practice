package com.itheima.web.servlet;

import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.UUIDUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 后台分类管理
 */
@WebServlet(name = "AdminCategoryServlet", urlPatterns = {"/adminCategory"})
public class AdminCategoryServlet extends BaseServlet {
    /**
     * 展示所有分类
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1,调用categoryservice查询所的分类信息 返回值list
        CategoryService cs = (CategoryService) BeanFactory.getBean("CategoryService");
        List<Category> list = cs.findAll();

        //2,将list放入request域中 请求转发即可
        request.setAttribute("list", list);
        return "/admin/category/list.jsp";
    }

    /**
     * 跳转到添加页面上
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String addUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/admin/category/add.jsp";

    }

    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1,接受cname
        String cname = request.getParameter("cname");

        //2,封装category
        Category c = new Category();
        c.setCid(UUIDUtils.getId());
        c.setCname(cname);

        //3,调用service完成添加操作
        CategoryService cs  = (CategoryService) BeanFactory.getBean("CategoryService");

        //4,重定向查询所有分类
        return null;
    }

}
