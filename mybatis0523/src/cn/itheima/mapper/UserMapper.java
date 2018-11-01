package cn.itheima.mapper;

import cn.itheima.pojo.QueryVo;
import cn.itheima.pojo.User;

import java.util.List;

public interface UserMapper {

    public User findUserById(Integer id);

    //动态代理形势中,如果返回结果集为List,那么mybatis在造成实现类的时候自动调用selectList方法
    public List<User> findUserByUserName(String username);

    public void insertUser(User user);

    public List<User> findUserbyVo(QueryVo vo);

    public Integer findUserCount();

}
