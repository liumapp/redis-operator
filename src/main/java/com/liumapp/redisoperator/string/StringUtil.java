package com.liumapp.redisoperator.string;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by liumapp on 11/13/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class StringUtil {

    @Resource(name = "redisTemplate")
    private ValueOperations<String , Object> valOps;

    public void set (String key , Object value) {
        valOps.set(key , value);
    }

    public Object get (String key) {
        return valOps.get(key);
    }
    
}
