package com.itheima.web.servlet;

import com.itheima.service.AccountService;
import com.itheima.service.AccountService4DB;
import com.itheima.service.AccountService4tl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 转账
 */
@WebServlet(name = "AccountServlet", urlPatterns = {"/account"})
public class AccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 0，设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter w = response.getWriter();

        // 1，接受三个参数
        String fromUser = request.getParameter("fromuser");
        String toUser = request.getParameter("touser");
        String money = request.getParameter("money");

        // 2，调用accountservice.account(fromuser,touser,money)
        try {
            //使用的threadlocal
            //new AccountService4tl().account(fromUser, toUser, money);

            //使用DButil
            new AccountService4DB().account(fromUser,toUser,money);
        } catch (Exception e) {
            e.printStackTrace();
            w.print("转账失败");
            return;
        }

        // 3，打印信息
        w.print("转账成功");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
