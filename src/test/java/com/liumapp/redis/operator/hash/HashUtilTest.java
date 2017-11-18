package com.liumapp.redis.operator.hash;

import com.liumapp.redis.operator.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liumapp on 11/17/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Main.class })
public class HashUtilTest {

    @Autowired
    private HashUtil hashUtil;

    /**
     * 创建一个散列集，并插入一个或多个键值对
     *
     * 并为后续的测试提供源数据
     */
    @Test
    public void put () {
        /**
         * 单插
         */
        hashUtil.put("hashKey" , "testKeyA" , "java");

        /**
         * 批量插
         */
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("testKeyB" , "python");
        map.put("testKeyC" , "c");
        map.put("testKeyD" , "c++");
        hashUtil.putAll("hashKey" , map);
    }

    /**
     * 判断key是否存在
     * 删除key
     */
    @Test
    public void isExists () {
        System.out.println("the hashList is : " + hashUtil.entries("hashKey"));
        if (hashUtil.hasKey("hashKey" , "testKeyA")) {
            hashUtil.delete("hashKey" , "testKeyA");
        }
        System.out.println("after delete , the hashlist now is : " + hashUtil.entries("hashKey"));
    }

        

}
