package cn.itheima.text;

import cn.itheima.mapper.UserMapper;
import cn.itheima.pojo.CustomOrders;
import cn.itheima.pojo.QueryVo;
import cn.itheima.pojo.User;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserMapperTest {

    private SqlSessionFactory factory;

    @Before
    public void setUp() throws Exception{
        String resource = "SqlMapConfig.xml";
        //通过流将核心配置文件读取出来
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //通过核心配置文件输入流来创建会话工厂
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception{
        SqlSession openSession = factory.openSession();
        //通过getMapper方法来实例化接口
        UserMapper mapper = openSession.getMapper(UserMapper.class);

        User user = mapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testFindUserByUseName() throws Exception {
        SqlSession openSession = factory.openSession();
        //通过getMapper方法来实例化接口
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        List<User> list = mapper.findUserByUserName("王");
        System.out.println(list);
    }

    @Test
    public void testInsertUser() throws Exception{
        SqlSession openSession = factory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("老王");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("北京昌平");

        mapper.insertUser(user);

        openSession.commit();
    }


    @Test
    public void testFindUserByVo() throws Exception{
        SqlSession openSession = factory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("王");
        user.setSex("1");
        vo.setUser(user);
        List<User> list = mapper.findUserbyVo(vo);
        System.out.println(list);

    }

    @Test
    public void testFindUserByCount(){
        SqlSession openSession = factory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        Integer count = mapper.findUserCount();
        System.out.println(count);
    }

    @Test
    public void testFindUserbyUserNameAndSex(){
        SqlSession openSession = factory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("王");
//        user.setSex("1");

        List<User> list = mapper.findUserByUserNameAndSex(user);
        System.out.println(list);
    }


    @Test
    public void testFindUserbyIds(){
        SqlSession openSession = factory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);

        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(16);
        ids.add(28);
        ids.add(22);
        vo.setIds(ids);
        List<User> list = mapper.findUserByIds(vo);
        System.out.println(list);
    }

    @Test
    public void testFindOrdersAndUser1(){
        SqlSession openSession = factory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);

        List<CustomOrders> list = mapper.findOrdersAndUser1();
        System.out.println(list);
    }



    @Test
    public void testFindOrdersAndUser2(){
        SqlSession openSession = factory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);

        List<Order> list = mapper.findOrdersAndUsers2();
        System.out.println(list);
    }


    @Test
    public void testFindUserAndOrders(){
        SqlSession openSession = factory.openSession();
        UserMapper mapper = openSession.getMapper(UserMapper.class);

        List<User> list = mapper.findUserAndOrders();
        System.out.println(list);
    }

}
