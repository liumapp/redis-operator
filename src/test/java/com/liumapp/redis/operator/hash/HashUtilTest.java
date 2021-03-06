package com.liumapp.redis.operator.hash;

import com.liumapp.redis.operator.RedisOperatorMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liumapp on 11/17/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RedisOperatorMain.class })
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

    @Test
    public void example () {

        HashMap<String , Object> hashmap = new HashMap<String, Object>();
        hashmap.put("a" , "hello worlt");
        hashmap.put("b" , "hello lm");

        HashMap<String , Object> hashMapb = new HashMap<String, Object>();
        hashMapb.put("a2" , "hello xy");
        hashMapb.put("b2" , "hello zl");

        hashUtil.put("hashmap" , "a" , "hello world");
        hashUtil.put("hashmap" , "b" , "hello lm");
        System.out.println("hashmap is : " + hashUtil.entries("hashmap"));

        hashUtil.putAll("hashMapb" , hashMapb);
        System.out.println("hashMapb is : " + hashUtil.entries("hashMapb"));

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

    /**
     * 根据多个key
     * 从散列中批量取出数据
     */
    @Test
    public void multyGet () {
        /**
         * 这个list存放要取出来的key
         */
        List<String> keys = new ArrayList<String>();

        keys.add("testKeyB");
        keys.add("testKeyC");
        keys.add("testKeyD");

        System.out.println("批量获取到的结果为： " + hashUtil.multyGet("hashKey" , keys));
    }

    /**
     * 获取一个散列集中一共有多少个key
     */
    @Test
    public void howManyKey () {
        System.out.println("hashKey散列表下一共有: " + hashUtil.size("hashKey") + "条key");
    }

    /**
     * 对散列集的迭代
     */
    @Test
    public void cursor () {
        Cursor<Map.Entry<String, Object>> cursor = hashUtil.scan("hashKey" , ScanOptions.NONE);
        System.out.println("开始遍历hashKey");
        while (cursor.hasNext()) {
            Map.Entry<String , Object> entry = cursor.next();
            System.out.println("key is : " + entry.getKey());
            System.out.println("value is : " + entry.getValue());
        }

    }


}
