package com.liumapp.redisoperator.string;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by liumapp on 11/13/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class StringUtil {

    @Resource(name = "redisTemplate")
    private ValueOperations<String , Object> valOps;

    /**
     * 设置一个字符串的值
     * @param key
     * @param value
     */
    public void set (String key , String value) {
        valOps.set(key , value);
    }

    /**
     * 偏移offset的位置后，再设置value的值
     * @param key
     * @param value
     * @param offset
     */
    public void set (String key , String value , long offset ) {
        valOps.set(key , value , offset);
    }

    /**
     * 设置指定时间内有效的value
     * @param key
     * @param value
     * @param timeout
     * @param unit
     */
    public void set (String key , String value , long timeout , TimeUnit unit) {
        valOps.set(key , value , timeout , unit.SECONDS);
    }

    public Object get (String key) {
        return valOps.get(key);
    }

    /**
     * 如何key已经存在，则不插入value，否则插入并返回true
     * @param key
     * @param value
     * @return
     */
    public boolean setIfAbsent (String key , Object value) {
        return valOps.setIfAbsent(key , value);
    }

}
