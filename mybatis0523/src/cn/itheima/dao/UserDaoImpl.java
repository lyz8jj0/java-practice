package cn.itheima.dao;

import cn.itheima.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    //通过构造方法注入
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(Integer id) {
        //sqlSession是线程不安全的,所以它的最
        SqlSession openSession = sqlSessionFactory.openSession();
        User user = openSession.selectOne("test.findUserById", id);
        return user;
    }

    @Override
    public List<User> findUserByUserName(String username) {
        SqlSession openSession = sqlSessionFactory.openSession();
        List<User> list  = openSession.selectList("test.findUserByUserName",username);
        return list;
    }
}
