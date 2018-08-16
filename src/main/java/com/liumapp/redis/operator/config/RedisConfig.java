package com.liumapp.redis.operator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

/**
 * Created by liumapp on 9/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Configuration
public class RedisConfig {

    @Bean
    @ConfigurationProperties(prefix = "liumapp.redis")
    public JedisConnectionFactory connectionFactory () {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("114.215.42.166");
        jedisConnectionFactory.setPort(6379);
        jedisConnectionFactory.setPassword("huluwa890TJ");
        jedisConnectionFactory.setDatabase(0);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String , Object> redisTemplate (JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String , Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);

        /**
         * 不设置Serializer的话
         * 将在StringUtilTest的testOffset中报如下错误：
         * Cannot deserialize; nested exception is org.springframework.core.serializer.support.SerializationFailedException: Failed to deserialize payload.
         */
        redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplatek (JedisConnectionFactory jedisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory);
        return stringRedisTemplate;
    }

}
