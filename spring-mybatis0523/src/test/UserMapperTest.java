package test;

import cn.itheima.mapper.UserMapper;
import cn.itheima.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception{
        String configLocation = "classpath:ApplicationContext.xml";
        applicationContext = new ClassPathXmlApplicationContext(configLocation);
    }

    @Test
    public void testFindUserById() throws Exception{
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }
}
