package com.itheima.web.servlet;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * 添加商品
 */
@WebServlet(name = "AddProductServlet", urlPatterns = {"/addProduct"})
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //0,设置编码
        request.setCharacterEncoding("utf-8");

        //扩展令牌机制
        //0.1获取session中令牌和提交过来的令牌
        String r_lingpai = request.getParameter("r_lingpai");
        String s_lingpai = (String) request.getSession().getAttribute("s_lingpai");

        //0.2移除session中的令牌
        request.getSession().removeAttribute("s_lingpai");

        //0.3比较两个令牌
        if (s_lingpai == null || !s_lingpai.equals(r_lingpai)) {
            //已经提交过了,生成错误信息放入request域中,到msg.jsp
            request.setAttribute("msg", "商品已经保存!");
            request.getRequestDispatcher("/msg.jsp").forward(request, response);
            return;
        }

        //1,封装数据
        Product p = new Product();
        try {
            BeanUtils.populate(p, request.getParameterMap());

            //1.1设置pid
            p.setPid(UUIDUtils.getId());

            //1.2设置时间
            p.setPdate(new Date());

            //2,调用service完成添加操作
            new ProductService().addPorduct(p);

            //3,页面跳转
            request.getRequestDispatcher("/findAll").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "添加商品失败");
            request.getRequestDispatcher("/msg.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
