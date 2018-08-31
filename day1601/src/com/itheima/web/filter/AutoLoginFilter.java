package com.itheima.web.filter;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.CookUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(filterName = "AutoLoginFilter", urlPatterns = {"/*"})
public class AutoLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1,强转
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //2,获取指定cookie
        Cookie c = CookUtils.getCookieByName("autologin", request.getCookies());
        //判断cookie是否为空
        //若不为空,获取值(username和password) 调用service完成登录,判断user是否为空,不为空放入session
        if (c != null) {
            String username = c.getValue().split("-")[0];
            String password = c.getValue().split("-")[1];

            //调用service完成登录
            User user = null;
            try {
                user = new UserService().login(username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (user != null) {
                //将user放入session中
                request.getSession().setAttribute("user", user);
            }
        }

        //3,放行
        chain.doFilter(req, resp);

    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
