package com.itheima.service;

import java.util.List;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;

public class CustomerService {
	
	/**
	 * 保存客户
	 * @param c
	 */
	public void saveCustomer(Customer c){
		new CustomerDao().save(c);
	}
	
	/**
	 * 查询所有的客户
	 * @return
	 */
	public List<Customer> findAll(){
		return new CustomerDao().findAll();
	}


	/**
	 * 带查询条件查询所有的客户
	 * @return
	 */
	public List<Customer> findAll(String custName){
		return new CustomerDao().findAll(custName);
	}
}
