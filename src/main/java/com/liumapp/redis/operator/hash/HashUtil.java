package com.liumapp.redis.operator.hash;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

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

    

}
