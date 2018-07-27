package com.itheima.c_life;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2018/7/27.
 */
public class LifeServlet implements Servlet {

    /**
     * 初始化方法
     * 执行者：服务器
     * 执行次数：一次
     * 执行时机：默认第一次访问的时候
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("5555555555555555");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 服务
     * 执行者：服务器
     * 执行次数：请求一次执行一次
     * 执行时机：请求来的时候
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("6666666");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 服务
     * 执行者：服务器
     * 执行次数：只执行一次
     * 执行时机：当servlet被移除的时候或服务器正常关闭的时候
     */
    @Override
    public void destroy() {
        System.out.println("4444444444");
    }

    /**
     * servlet 是一个单实例多线程
     * 默认第一次访问的时候，服务器创建servlet，并调用init实现初始化操作，并调用一次service方法
     * 每当请求来的时候，服务器创建一个线程，调用service方法执行自己的业务逻辑
     * 当月servlet被移除的时候服务器正常关闭的时候，服务器调用servlet的destroy方法实现销毁操作
     */


}
