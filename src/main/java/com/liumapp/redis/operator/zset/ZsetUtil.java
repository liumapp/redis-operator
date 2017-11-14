package com.liumapp.redis.operator.zset;

import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by liumapp on 11/13/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class ZsetUtil {

    @Resource(name = "redisTemplate")
    private ZSetOperations zsetOps;

}
