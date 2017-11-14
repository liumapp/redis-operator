package com.liumapp.redis.operator.hash;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by liumapp on 11/13/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class HashUtil {

    @Resource(name = "redisTemplate")
    private HashOperations hashOps;

    
}
