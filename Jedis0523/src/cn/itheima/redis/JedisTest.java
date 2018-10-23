package cn.itheima.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {
    @Test
    public void testJedis1(){
        //创建和redis的连接
        Jedis jedis = new Jedis("172.16.12.27",6379);

        jedis.set("key2","2");

        System.out.println(jedis.get("key2"));

        jedis.close();
    }

    @Test
    public void testJedisPool(){
        //创建连接池
        JedisPool pool = new JedisPool("172.16.12.27",6379);
        //获取连接
        Jedis jedis = pool.getResource();
        jedis.set("key3","aaa");
        System.out.println(jedis.get("key3"));
        //使用连接时,连接使用完后一定要关闭,关闭后连接会自动回到连接池供别人使用,如果不关闭则连接被耗尽后会死机
        jedis.close();
        //关闭连接池
        pool.close();
    }

}
