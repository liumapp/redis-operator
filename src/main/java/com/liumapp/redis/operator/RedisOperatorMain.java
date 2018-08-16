package com.liumapp.redis.operator;

import com.liumapp.redis.operator.config.RedisConfig;
import com.liumapp.redis.operator.hash.HashUtil;
import com.liumapp.redis.operator.list.ListUtil;
import com.liumapp.redis.operator.set.SetUtil;
import com.liumapp.redis.operator.string.StringUtil;
import com.liumapp.redis.operator.zset.ZsetUtil;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
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
public class RedisOperatorMain {

    @Bean
    public StringUtil stringUtil () {
        return new StringUtil();
    }

    @Bean
    public ListUtil listUtil () {
        return new ListUtil();
    }

    @Bean
    public HashUtil hashUtil () {
        return new HashUtil();
    }

    @Bean
    public SetUtil setUtil () {
        return new SetUtil();
    }

    @Bean
    public ZsetUtil zsetUtil () {
        return new ZsetUtil();
    }

}
