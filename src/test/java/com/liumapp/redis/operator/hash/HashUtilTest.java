package com.liumapp.redis.operator.hash;

import com.liumapp.redis.operator.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void put () {
        
    }

}
