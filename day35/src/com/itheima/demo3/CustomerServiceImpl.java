package com.itheima.demo3;

public class CustomerServiceImpl {

    //提供成员属性,提供set方法
    private CustomerDaoImpl customerDao;

    public void setCustomerDao(CustomerDaoImpl customerDao) {
        this.customerDao = customerDao;
    }

    public void save(){
        System.out.println("我是业务层service.....");
        //原来的编写方式
        //new CustomerDaoImpl().save();

        //Spring
        customerDao.save();

    }

}
