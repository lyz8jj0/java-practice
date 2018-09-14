package com.itheima.web.servlet;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.service.impl.ProductServiceImpl;
import com.itheima.utils.CookUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

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
        // 0，设置编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter w = response.getWriter();

        //获取商品的id
        String pid = request.getParameter("pid");

        //调用service
        ProductService ps = new ProductServiceImpl();
        Product p = ps.getByPid(pid);
        //将结果放入request中请求转发
        request.setAttribute("bean", p);

        //获取指定的cookies
        Cookie c = CookUtils.getCookieByName("pids", request.getCookies());
        String pids;
        //判断cookies是否为空
        if (c == null) {
            //若cookies为空
            pids = pid;
        } else {
            //若cookie不为空,继续判断pids是否包含pid //pids = 2-1-11
            //获取值
            pids = c.getValue();
            String[] arr = pids.split("-");
            //将数组转成集合 些list长度不可变
            List<String> asList = Arrays.asList(arr);
            //将asList放入一个新list中
            LinkedList<String> list = new LinkedList<>(asList);

            if (list.contains(pid)) {
                //ids中包含pid,将pid移除放到最前面
                list.remove(pid);
                list.addFirst(pid);
            } else {
                //ids不包含id,继续判断长度是否大于2
                if (list.size() > 2) {
                    //长度>=3移除最后一个 将当前的放入到最前面
                    list.removeLast();
                    list.addFirst(pid);
                } else {
                    list.addFirst(pid);
                }
            }
            pids="";
            //将list转化为字符串
            for (String s : list) {
                pids += (s + "-");

            }
            pids = pids.substring(0, pids.length() - 1);
        }
        //将pids写回去
        c = new Cookie("pids", pids);
        //设置访问路径
        c.setPath(request.getContextPath() + "/");
        //设置存活时间
        c.setMaxAge(3600);
        //写回浏览器
        response.addCookie(c);
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
