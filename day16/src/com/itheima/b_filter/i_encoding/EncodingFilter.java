package com.itheima.b_filter.i_encoding;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = {"/*"})
public class EncodingFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1,强转
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //2,放行 将包装过的request传递
        chain.doFilter(new MyRequset(request), resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}

class MyRequset extends HttpServletRequestWrapper {


    private final HttpServletRequest request;

    public MyRequset(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        //获取请求方式
        String m = request.getMethod();
        if ("get".equals(m)) {
            //get
            String value = request.getParameter(name);
            try {
                return new String(value.getBytes("iso8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
            }
        } else if ("post".equals(m)) {
            try {
                request.setCharacterEncoding("utf-8");
            } catch (UnsupportedEncodingException e) {
            }
            return request.getParameter(name);
        }
        return super.getParameter(name);

    }
}