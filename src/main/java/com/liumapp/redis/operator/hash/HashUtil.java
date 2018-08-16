package com.liumapp.redis.operator.hash;

import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 散列集
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
     * @param hashKey object hash key
     * @param key string map key
     * @param value string map value
     */
    public void put (Object hashKey , String key , Object value) {
        hashOps.put(hashKey , key , value);
    }

    /**
     * 仅当key不存在时才设置散列hashKey对应的key值。
     * @param hashKey object hash key
     * @param key string map key
     * @param value string map value
     * @return boolean
     */
    public Boolean putIfAbsent (Object hashKey , String key , Object value) {
        return hashOps.putIfAbsent(hashKey , key , value);
    }

    /**
     * 把一个map装入hash中
     * @param hashKey object hash key
     * @param map hash map
     */
    public void putAll (Object hashKey , Map<String , Object> map) {
        hashOps.putAll(hashKey , map);
    }

    /**
     * 批量删除hash中的键值对
     * @param hashKey object hash key
     * @param keys string ... keys
     * @return long
     */
    public Long delete (Object hashKey , String... keys) {
        return hashOps.delete(hashKey , keys);
    }

    /**
     * 判断一个hash中是否存在指定的键值对
     * @param hashKey object hash key
     * @param key string key
     * @return boolean
     */
    public boolean hasKey (Object hashKey , String key) {
        return hashOps.hasKey(hashKey , key);
    }

    /**
     * 获取hash中指定的键值
     * @param hashKey object hash key
     * @param key string key
     * @return object
     */
    public Object get (Object hashKey , String key) {
        return hashOps.get(hashKey , key);
    }

    /**
     * 批量获取
     * @param hashKey object hash key
     * @param collection collection
     * @return list
     */
    public List<Object> multyGet (Object hashKey , Collection collection) {
        return hashOps.multiGet(hashKey , collection);
    }

    /**
     * key对应的值自增number的数值
     * @param hashKey object hash key
     * @param key string key
     * @param number long number
     * @return long
     */
    public Long increment (Object hashKey , String key , long number) {
        return hashOps.increment(hashKey , key , number);
    }

    /**
     * 浮点数的自增
     * @param hashKey objct hash key
     * @param key string key
     * @param number double number
     * @return double
     */
    public Double increment (Object hashKey , String key , double number) {
        return hashOps.increment(hashKey , key , number);
    }

    /**
     * 获取一个散列集里所有的key
     * @param hashKey object hash key
     * @return set
     */
    public Set keys (Object hashKey) {
        return hashOps.keys(hashKey);
    }

    /**
     * 返回一个散列集里所有的value
     * @param hashKey object hash key
     * @return list
     */
    public List values (Object hashKey) {
        return hashOps.values(hashKey);
    }

    /**
     * 返回一个散列集里一共有多少个key
     * @param hashKey object hash key
     * @return long
     */
    public Long size (Object hashKey) {
        return hashOps.size(hashKey);
    }

    /**
     * 获取散列集里所有的键值对
     * @param hashKey object hash key
     * @return map \<string, object>
     */
    public Map<String , Object> entries (Object hashKey) {
        return hashOps.entries(hashKey);
    }

    /**
     * 迭代查询散列集中的数据
     * @param hashKey object hash key
     * @param scanOptions scan options
     * @return cursor
     */
    public Cursor<Map.Entry<String , Object>> scan (Object hashKey , ScanOptions scanOptions ) {
        return hashOps.scan(hashKey , scanOptions);
    }

}
