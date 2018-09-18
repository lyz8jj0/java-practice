package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.domain.Order.Order;
import com.itheima.domain.OrderItem;
import com.itheima.service.OrderService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.DataSourceUtils;

public class OrderServiceImpl implements OrderService {
    @Override
    public void add(Order order) throws Exception {
        try {
            //1,开启事务
            DataSourceUtils.startTransaction();

            OrderDao od = (OrderDao) BeanFactory.getBean("OrderDao");
            //2,向orders表中添加一个数据
            od.add(order);


//            int i =1/0;

            //3,向orderitem中添加多条数据
            for (OrderItem oi : order.getItems()) {
                od.addItem(oi);
            }

            //4,事务处理
            DataSourceUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            DataSourceUtils.rollbackAndClose();
            throw e;
        }

    }
}
