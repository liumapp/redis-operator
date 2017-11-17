package com.liumapp.redis.operator;

import com.liumapp.redis.operator.config.RedisConfig;
import com.liumapp.redis.operator.hash.HashUtil;
import com.liumapp.redis.operator.list.ListUtil;
import com.liumapp.redis.operator.set.SetUtil;
import com.liumapp.redis.operator.string.StringUtil;
import com.liumapp.redis.operator.zset.ZsetUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by liumapp on 9/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Configuration
@Import({RedisConfig.class})
public class Main {

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
