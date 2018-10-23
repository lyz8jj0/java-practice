package com.itheima.servlet;

import com.itheima.domain.Linkman;
import com.itheima.service.LinkmanServer;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 添加联系人
 */
@WebServlet(name = "AddLinkmanServlet", urlPatterns = {"/addLinkman"})
public class AddLinkmanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //接收数据
        Map<String, String[]> map = request.getParameterMap();
        //先把客户的id获取到
        String scust_id = map.get("cust_id")[0];
        //转换
        Long cust_id = Long.parseLong(scust_id);

        //封装数据
        Linkman man = new Linkman();
        try {
            //封装数据
            BeanUtils.populate(man, map);

            //调用业务层,保存联系人
            new LinkmanServer().save(man,cust_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
