package cn.itheima.mapper;

import cn.itheima.pojo.CustomOrders;
import cn.itheima.pojo.QueryVo;
import cn.itheima.pojo.User;
import org.apache.logging.log4j.core.config.Order;

import java.util.List;

public interface UserMapper {

    public User findUserById(Integer id);

    //动态代理形势中,如果返回结果集为List,那么mybatis在造成实现类的时候自动调用selectList方法
    public List<User> findUserByUserName(String username);

    public void insertUser(User user);

    public List<User> findUserbyVo(QueryVo vo);

    public Integer findUserCount();

    public List<User> findUserByUserNameAndSex(User user);

    public List<User> findUserByIds(QueryVo vo);

    public List<CustomOrders> findOrdersAndUser1();

    public List<Order> findOrdersAndUsers2();

    public List<User> findUserAndOrders();

}
