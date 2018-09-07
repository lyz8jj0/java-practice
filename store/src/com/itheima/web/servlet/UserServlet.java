package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.myconventer.MyConventer;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import com.itheima.utils.MD5Utils;
import com.itheima.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 和用户相关的servlet
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends BaseServlet {
    public String add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("userServlet的add方法执行了");
        return null;
    }

    /**
     * 跳转到注册页面
     *
     * @param request
     * @param response
     * @return
     */
    public String registUI(HttpServletRequest request, HttpServletResponse response) {
        return "/jsp/register.jsp";

    }

    /**
     * 用户注册
     *
     * @param request
     * @param response
     * @return
     */
    public String regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1,封装数据
        User user = new User();

        //注册自定义转化器
        ConvertUtils.register(new MyConventer(), Date.class);
        BeanUtils.populate(user, request.getParameterMap());

        //1.1设置用户id
        user.setUid(UUIDUtils.getId());

        //1.2设置激活码
        user.setCode(UUIDUtils.getCode());

        //1.3加密密码
        user.setPassword(MD5Utils.md5(user.getPassword()));

        //2,调用service完成注册
        UserService s = new UserServiceImpl();
        s.regist(user);

        //页面请求转发
        request.setAttribute("msg", "用户注册已成功,请去邮箱激活~~~");
        return "/jsp/msg.jsp";
    }

    /**
     * 用户激活
     *
     * @param request
     * @param response
     * @return
     */
    public String active(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //1,获取激活码
        String code = request.getParameter("code");

        //2,调用service完成激活
        UserService s = new UserServiceImpl();
        User user = s.active(code);
        if (user == null) {
            //通过激活码没有找到用户
            request.setAttribute("msg", "请重新激活");
        } else {
            //添加信息
            request.setAttribute("msg", "激活成功");
        }
        return "/jsp/msg.jsp";

    }

}
