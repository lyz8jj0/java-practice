package com.itheima.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "PrivilegeFilter")
public class PrivilegeFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1,强转
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //2,业务逻辑
        //从session中获取user 判断user是否为空 请求转发
//        User user = (User) request.getSession().getAt tribute("user");
//        if (user == null) {
//            request.setAttribute("msg", "没有权限,请先登录!");
//            request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
//            return;
//        }

        //放行
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
