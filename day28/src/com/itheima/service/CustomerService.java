package com.itheima.service;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;

import java.util.List;

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
    public List<Customer> findAll() {

        return new CustomerDao().findAll();
    }

    /**
     * 带查询条件的所有客户
     *
     * @return
     */
    public List<Customer> findAll(String custName) {

        return new CustomerDao().findAll(custName);
    }
}
