package com.itheima.service;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;

public class CustomerService {
    /**
     * 保存客户
     *
     * @param c
     */
    public void saveCustomer(Customer c) {
        new CustomerDao().save(c);
    }

    /**
     * 查询客户列表
     *
     * @return
     */
    public Customer getCustomerList() {
        return new CustomerDao().getCustomerList();
    }
}
