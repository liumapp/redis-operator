package com.liumapp.redis.operator.set;

import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Redis中的Set是String的无序集合
 * Created by liumapp on 11/13/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class SetUtil {

    @Resource(name = "redisTemplate")
    private SetOperations setOps;

    

}
