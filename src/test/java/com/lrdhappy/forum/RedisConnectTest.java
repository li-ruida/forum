package com.lrdhappy.forum;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

/**
 * @author lrd
 * @date 2023-02-01 14:49
 */
@SpringBootTest
public class RedisConnectTest {
    @Test//Jedis connect test
    public void testJedis(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        jedis.set("test","test");
        System.out.println(jedis.get("test"));
        System.out.println(jedis.del("test"));
        jedis.close();
    }
}
