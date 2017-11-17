package com.liumapp.redis.operator.hash;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by liumapp on 11/13/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class HashUtil {

    @Resource(name = "redisTemplate")
    private HashOperations hashOps;

    /**
     * 插入新的hash
     */
    public void put (Object hashKey , String key , Object value) {
        hashOps.put(hashKey , key , value);
    }

    /**
     * 仅当key不存在时才设置散列hashKey对应的key值。
     */
    public Boolean putIfAbsent (Object hashKey , String key , Object value) {
        return hashOps.putIfAbsent(hashKey , key , value);
    }

    /**
     * 把一个map装入hash中
     */
    public void putAll (Object hashKey , Map<String , Object> map) {
        hashOps.putAll(hashKey , map);
    }

    /**
     * 批量删除hash中的键值对
     */
    public Long delete (Object hashKey , String... keys) {
        return hashOps.delete(hashKey , keys);
    }

    /**
     * 判断一个hash中是否存在指定的键值对
     * @return boolean
     */
    public boolean hasKey (Object hashKey , String key) {
        return hashOps.hasKey(hashKey , key);
    }

    /**
     * 获取hash中指定的键值
     */
    public Object get (Object hashKey , String key) {
        return hashOps.get(hashKey , key);
    }

    /**
     * 批量获取
     */
    public List<Object> multyGet (Object hashKey , Collection<Object> collection) {
        return hashOps.multiGet(hashKey , collection);
    }

    /**
     * key对应的值自增number的数值
     */
    public Long increment (Object hashKey , String key , long number) {
        return hashOps.increment(hashKey , key , number);
    }

    /**
     * 浮点数的自增
     */
    public Double increment (Object hashKey , String key , double number) {
        return hashOps.increment(hashKey , key , number);
    }

    /**
     * 获取一个散列集里所有的key
     */
    public Set keys (Object hashKey) {
        return hashOps.keys(hashKey);
    }

    /**
     * 返回一个散列集里所有的value
     */
    public List values (Object hashKey) {
        return hashOps.values(hashKey);
    }

    /**
     * 返回一个散列集里一共有多少个key
     */
    public Long size (Object hashKey) {
        return hashOps.size(hashKey);
    }

    /**
     * 获取散列集里所有的键值对
     */
    public Map<String , Object> entries (Object hashKey) {
        return hashOps.entries(hashKey);
    }

        

}
