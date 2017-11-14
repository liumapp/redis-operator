package com.liumapp.redisoperator.string;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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

    /**
     * 批量添加
     * @param map
     */
    public void multiSet (HashMap<String , String> map) {
        valOps.multiSet(map);
    }

    public List<Object> multiGet (List<String> listKey) {
        return valOps.multiGet(listKey);
    }

    /**
     * 设置value的同时返回旧值
     * @param key
     * @param value
     * @return
     */
    public Object getAndSet (String key , Object value) {
        return valOps.getAndSet(key , value);
    }

    /**
     * 在原来数值的基础上自增num的值
     * @param key
     * @param num
     * @return
     */
    public Long increment (String key , Long num) {
        return valOps.increment(key , num);
    }

    /**
     * num也可以是浮点数
     * @param key
     * @param num
     * @return
     */
    public Double increment (String key , Double num) {
        return valOps.increment(key , num);
    }

    /**
     * 在原来字符串的末尾追加value
     * @param key
     * @param value
     */
    public void append (String key , String value) {
        valOps.append(key , value);
    }

    public String get (String key , Long start , Long end) {
        return valOps.get(key , start , end);
    }

    /**
     * 返回value值的长度
     * @param key
     * @return
     */
    public Long size (String key) {
        return valOps.size(key);
    }

    /**
     * 对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)
     * key键对应的值value对应的ascii码,在offset的位置(从左向右数)变为value
     * true:设置为1
     * false:设置为0
     * @param key
     * @param offset
     * @param value
     */
    public void setBit (String key , Long offset , boolean value) {
        valOps.setBit(key , offset , value);
    }

    public boolean getBit (String key , Long offset) {
        return valOps.getBit(key , offset);
    }



}
