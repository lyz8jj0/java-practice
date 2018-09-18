package com.itheima.web.servlet;

import com.itheima.domain.Cart;
import com.itheima.domain.CartItem;
import com.itheima.domain.Order.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.User;
import com.itheima.service.OrderService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.UUIDUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


/**
 * 订单模块
 */
@WebServlet(name = "OrderServlet", urlPatterns = {"/order"})
public class OrderServlet extends BaseServlet {
    /**
     * 生成订单
     *
     * @param request
     * @param response
     * @return
     */
    public String add(HttpServletRequest request, HttpServletResponse response) {
        //0,判断用户是否登录
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("msg", "请先登录~~~~");
            return "jsp/msg.jsp";
        }

        //1,封装数据
        Order order = new Order();
        //1.1订单id
        order.setOid(UUIDUtils.getId());

        //1.2,订单时间
        order.setOrdertime(new Date());


        //1.3总金额
        //获取session中的cart
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        order.setTotal(cart.getTotal());

        //1.4订单的所有订单项
        /**
         * 先获取cart中items
         * 遍历items 组装成orderItems
         * 将orderItem添加到list(items)中
         */
        for (CartItem cartItem : cart.getItems()) {
            OrderItem oi = new OrderItem();

            //设置id
            oi.setItemid(UUIDUtils.getId());
            //设置购买数量
            oi.setCount(cartItem.getCount());
            //设置小计
            oi.setSubtotal(cartItem.getSubtotal());
            //设置product
            oi.setProduct(cartItem.getProduct());
            //设置order
            oi.setOrder(order);
            //添加到list中
            order.getItems().add(oi);
        }

        //1.5设置用户
        order.setUser(user);

        //2,调用service 添加订单
        OrderService os = (OrderService) BeanFactory.getBean("OrderService");
        os.add(order);

        //3,将order放入request域中,请求转发
        request.setAttribute("bean", order);

        return "/jsp/order_info.jsp";
    }
}
