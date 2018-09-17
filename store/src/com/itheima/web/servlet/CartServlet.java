package com.itheima.web.servlet;

import com.itheima.domain.Cart;
import com.itheima.domain.CartItem;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.utils.BeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 购物车模块
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends BaseServlet {
    /**
     * 获取购物车
     *
     * @param request
     * @return
     */
    private Cart getCart(HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //判断
        if (cart == null) {
            //创建一个cart
            cart = new Cart();

            //添加到session中
            request.getSession().setAttribute("cart", cart);
        }
        return cart;
    }

    /**
     * 添加到购物车
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1,获取pid和数量
        String pid = request.getParameter("pid");
        int count = Integer.parseInt(request.getParameter("count"));

        //2,通过pid调用ProdcutService通过pid获取一个商品
        ProductService ps = (ProductService) BeanFactory.getBean("ProductService");
        Product product = ps.getByPid(pid);

        //3,组装成CartItem
        CartItem cartItem = new CartItem(product, count);

        //4,添加到购物车中
        Cart cart = getCart(request);
        cart.add2Cart(cartItem);

        //5,重定向
        response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
        return null;
    }

    /**
     * 从购物车中移除购物项
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1,获取商品的pid
        String pid = request.getParameter("pid");

        //2,调用购物车的remove方法
        getCart(request).removeFromCart(pid);

        //3,重定向
        response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
        return null;
    }

    /**
     * 清空购物车
     *
     * @param request
     * @param response
     * @return
     */
    public String clear(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取购物车 清空
        getCart(request).clearCart();
        response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
        return null;
    }


}
