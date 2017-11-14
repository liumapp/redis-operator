package com.liumapp.redisoperator.string;

import com.liumapp.redisoperator.Main;
import com.liumapp.redisoperator.config.RedisConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}
