package com.liumapp.redis.operator;

import com.liumapp.redis.operator.list.ListUtil;
import com.liumapp.redis.operator.string.StringUtil;
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

    @Bean
    public ListUtil listUtil () {
        return new ListUtil();
    }

}
