package com.liumapp.redis.operator.zset;

import com.liumapp.redis.operator.Main;
import com.liumapp.redis.operator.config.RedisConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liumapp on 11/14/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class , RedisConfig.class})
public class ZsetUtilTest {
}
