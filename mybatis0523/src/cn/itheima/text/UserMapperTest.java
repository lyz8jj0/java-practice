package cn.itheima.text;

import cn.itheima.mapper.UserMapper;
import cn.itheima.pojo.QueryVo;
import cn.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
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
}
