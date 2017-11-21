package com.liumapp.redis.operator.set;

import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Redis中的Set是String的无序集合
 * 集合成员是唯一的 这就意味着集合中不能出现重复的数据
 * 集合是通过哈希表实现的 所以添加 删除 查找的复杂度都是O(1)
 * Created by liumapp on 11/13/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class SetUtil {

    @Resource(name = "redisTemplate")
    private SetOperations setOps;

    

}
