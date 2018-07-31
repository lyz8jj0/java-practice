package com.itheima.servlet;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * 用户注册
 */
@WebServlet(name = "RegistServlet", urlPatterns = {"/regist"})
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码
        request.setCharacterEncoding("utf-8");

        //1,封装数据
        //创建一个user 调用user.setXXX()一个个封装不推荐
        //使用beanutils封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());

            //2,调用userService.regist(user) 返回值:int
            int i = new UserService().regist(user);

            //3,判断int信息将信息请求转发到msgServlet
            if (i == 1) {
                request.setAttribute("msg", "添加成功");
                request.getRequestDispatcher("/msg").forward(request, response);
            } else {
                request.setAttribute("msg", "添加失败");
                request.getRequestDispatcher("/msg").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
