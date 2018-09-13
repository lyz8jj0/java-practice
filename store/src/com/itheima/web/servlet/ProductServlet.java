package com.itheima.web.servlet;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.service.impl.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 商品servlet
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends BaseServlet {
    /**
     * 通过id查询单个商品详情
     *
     * @param request
     * @param response
     * @return
     */
    public String getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取商品的id
        String pid = request.getParameter("pid");

        //调用service
        ProductService ps = new ProductServiceImpl();
        Product p = ps.getByPid(pid);
        //将结果放入request中请求转发
        request.setAttribute("bean", p);
        return "/jsp/product_info.jsp";
    }

    /**
     * 分页查询数据
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String findByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1，获取类别当前页，设置一个pageSize
        String cid = request.getParameter("cid");
        int currPage = Integer.parseInt(request.getParameter("currPage"));
        int pageSize = 12;

        //2,调用service 返回值pagebean
        ProductService ps = new ProductServiceImpl();
         PageBean<Product> bean = ps.findByPage(currPage, pageSize, cid);

        //3,将结果放入request中请求转发
        request.setAttribute("pb", bean);
        return "/jsp/product_list.jsp";
    }
}
