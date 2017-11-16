package com.liumapp.redis.operator.list;

import com.liumapp.redis.operator.Main;
import com.liumapp.redis.operator.config.RedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liumapp on 11/14/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class , RedisConfig.class})
public class ListUtilTest {

    @Autowired
    private ListUtil listUtil;

    /**
     * left push many data
     */
    @Test
    public void leftPushAll () {
        String[] strings = new String[]{"java" , "php" , "python"};
        Long result = listUtil.leftPushAll("languagetype" , strings);
        System.out.println("insert index is : " + result);
        System.out.println("insert data is : " + listUtil.range("languagetype" , 0 , -1));
    }

    /**
     * left push one data
     */
    @Test
    public void leftPush () {
        String string = "c++";
        Long result = listUtil.leftPush("languagetype" , string);
        System.out.println("insert index is : " + result);
        System.out.println("after insert , the data list is : " + listUtil.range("languagetype" , 0 , -1));
    }

    /**
     * 如果列表存在，则插入data
     */
    @Test
    public void leftPushIfPresent () {
        String string = "isPresentTest";
        String key = "isPresent";
        System.out.println("begin insert , insert into list which key is not exists:");
        Long result = listUtil.leftPushIfPresent(key , string);
        System.out.println("insert id is : " + result + " and 0 means did't insert success");

        String string2 = "testData";
        System.out.println("insert a key named isPresent:");
        Long result2 = listUtil.leftPush(key , string2);
        System.out.println("insert id is : " + result2);

        System.out.println("now insert isPresentTest again:");
        Long result3 = listUtil.leftPushIfPresent(key , string);
        System.out.println("insert id is : " + result3);
    }

    /**
     * 请先运行leftpushall和leftpush这两个测试方法
     * 把php修改为c
     */
    @Test
    public void set () {
        String key = "languagetype";
        System.out.println("the old data is : " + listUtil.range(key , 0 , -1));

        System.out.println("change php to c :");
        listUtil.set(key , (long) 2 , "c");

        System.out.println("the new data is : " + listUtil.range(key , 0 , -1));
    }

    /**
     * 请先运行leftpushall leftpush set 这三个测试方法
     * 把c删除 第一次出现的c
     */
    @Test
    public void remove () {
        String key = "languagetype";
        System.out.println("the old data is : " + listUtil.range(key , 0 , -1));

        listUtil.remove(key , (long) 1 , "c");

        System.out.println("the new data is : " + listUtil.range(key , 0 , -1));
    }


}
