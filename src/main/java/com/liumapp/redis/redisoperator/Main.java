package com.liumapp.redis.redisoperator;

import com.liumapp.redis.redisoperator.string.StringUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liumapp on 9/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Configuration
public class Main {

    @Bean
    public StringUtil stringUtil () {
        return new StringUtil();
    }

}
