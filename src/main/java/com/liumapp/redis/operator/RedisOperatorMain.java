package com.liumapp.redis.operator;

import com.liumapp.redis.operator.config.RedisConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * author liumapp
 * file RedisOperatorMain.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/8/16
 */
@EnableAutoConfiguration
@Configuration
@Import({RedisConfig.class})
@ComponentScan(value = "com.liumapp.redis.operator")
public class RedisOperatorMain {

}
