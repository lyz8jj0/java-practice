package com.itheima.dao.impl;

import com.itheima.dao.OrderDao;
import com.itheima.domain.Order.Order;
import com.itheima.domain.OrderItem;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

public class OrderDaoImpl implements OrderDao {

    /**
     * 添加一条订单
     *
     * @param order
     * @throws Exception
     */
    @Override
    public void add(Order order) throws Exception {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "inset";
    }

    /**
     * 添加一条订单项
     *
     * @param oi
     * @throws Exception
     */
    @Override
    public void addItem(OrderItem oi) throws Exception {

    }
}
