package com.itheima.c_proxy.encoding;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@WebFilter(filterName = "EncodingFilter", urlPatterns = {"/login"})
public class EncodingFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1,强转
        final HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //创建代理对象
        HttpServletRequest requestProxy = (HttpServletRequest) Proxy.newProxyInstance(HttpServletRequest.class.getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("getParameter".equals(method.getName())) {
                    //获取请求方式
                    String m = request.getMethod();
                    if ("get".equalsIgnoreCase(m)) {
                        String s = (String) method.invoke(request, args); //相当于request.getParameter(args)
                        return new String(s.getBytes("iso8859-1"), "utf-8");
                    } else if ("post".equalsIgnoreCase(m)) {
                        request.setCharacterEncoding("utf-8");
                        return method.invoke(request, args);
                    }
                }

                //不需要加强的方法
                return method.invoke(request, args);
            }
        });

        //2,放行
        chain.doFilter(requestProxy, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
