package com.itheima.b_request.e_header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 操作请求头
 */
@WebServlet(name = "HeaderServlet",urlPatterns = {"/header"})
public class HeaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取浏览器内核
        String agent = request.getHeader("user-agent");
        System.out.println(agent);

        //获取referer
        String referer = request.getHeader("referer");
        if(referer == null){
            System.out.println("直接在地址栏上输入的");
        }else if(referer.contains("localhost")){
            System.out.println("我自己点的。。。");
        }else if(referer.contains("192.168.")){
            System.out.println("哥们姐们点的");
        }else {
            System.out.println("盗链者可耻");
        }
    }
}
