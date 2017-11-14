package com.liumapp.redis.redisoperator.string;

import com.liumapp.redis.redisoperator.Main;
import com.liumapp.redis.redisoperator.config.RedisConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liumapp on 11/13/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class , RedisConfig.class})
public class StringUtilTest {

    @Autowired
    private StringUtil stringUtil;

    @Test
    public void set() {
        stringUtil.set("name" , "lm");
        System.out.println(stringUtil.get("name"));
        Assert.assertEquals("lm" , stringUtil.get("name"));
    }

    @Test
    public void setOffset() {
        stringUtil.set("name" , "hello world");
        stringUtil.set("name" , "liumapp" , 6);
        System.out.println(stringUtil.get("name"));
        Assert.assertEquals("hello liumapp" , stringUtil.get("name"));
    }

    @Test
    public void setIfAbsent() {
        if (stringUtil.setIfAbsent("nothing" , "something")) {
            System.out.println("nothing未存在，将插入something");
            System.out.println("something is : " + stringUtil.get("nothing"));
        } else {
            System.out.println("nothing已经存在，不会插入something");
            System.out.println("something is : " + stringUtil.get("nothing"));
        }
        Assert.assertEquals("something" , stringUtil.get("nothing"));
    }

    @Test
    public void multiSet() {
        HashMap<String , String> map = new HashMap<String, String>();
        map.put("multiKey1" , "multiValue1");
        map.put("multiKey2" , "multiValue2");
        map.put("multiKey3" , "multiValue3");
        stringUtil.multiSet(map);

        List<String> listKey = new ArrayList<String>();
        listKey.add("multiKey1");
        listKey.add("multiKey2");
        listKey.add("multiKey3");
        System.out.println(stringUtil.multiGet(listKey));
    }

    @Test
    public void getAndSet() {
        stringUtil.set("oldKey" , "oldValue");
        String oldValue = (String) stringUtil.getAndSet("oldKey" , "newValue");
        String newValue = (String) stringUtil.get("oldKey");
        Assert.assertEquals("oldValue" , oldValue);
        Assert.assertEquals("newValue" , newValue);
    }

    /**
     * 'a' 的ASCII码是 97 转换为二进制是：01100001
     * 'b' 的ASCII码是 98 转换为二进制是：01100010
     * 所以a到b的转换是把第7位置1,第8位置0
     */
    @Test
    public void setBit() {
        stringUtil.set("bitTest" , "a");
        stringUtil.setBit("bitTest" , (long) 6 , true);
        stringUtil.setBit("bitTest" , (long) 7 , false);
        Assert.assertEquals("b" , stringUtil.get("bitTest"));
    }

}
