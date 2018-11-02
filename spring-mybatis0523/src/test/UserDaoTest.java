package test;

import cn.itheima.dao.UserDao;
import cn.itheima.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception{
        String configLocation = "ApplicationContext.xml";
        applicationContext = new ClassPathXmlApplicationContext(configLocation);
    }

    @Test
    public void testFindUserById() throws Exception{
        //获取UserDao对象,getBean中字符串是在ApplicationContext.xml中声明的
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        User user = userDao.findUserById(1);
        System.out.println(user);
    }
}
