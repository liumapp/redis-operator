package com.liumapp.redis.operator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import java.time.Duration;

/**
 * file RedisConfig.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/9/18
 */
@Configuration
public class RedisConfig {

    @Bean
    @ConfigurationProperties(prefix = "liumapp.redis")
    public RedisConnector redisConnector () {
        RedisConnector redisConnector = new RedisConnector();
        redisConnector.setHostName("localhost");
        redisConnector.setPassword("adminadmin");
        redisConnector.setPort(6379);
        redisConnector.setDbIndex(0);
        return redisConnector;
    }

    @Bean
    public JedisConnectionFactory connectionFactory (RedisConnector redisConnector) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration ();
        redisStandaloneConfiguration.setHostName(redisConnector.getHostName());
        redisStandaloneConfiguration.setPort(redisConnector.getPort());
        redisStandaloneConfiguration.setPassword(RedisPassword.of(redisConnector.getPassword()));

        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
        jedisClientConfiguration.connectTimeout(Duration.ofMillis(5000));//  connection timeout

        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration,
                jedisClientConfiguration.build());
        return factory;
    }

    @Bean
    public RedisTemplate<String , Object> redisTemplate (JedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String , Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        /**
         * 不设置Serializer的话
         * 将在StringUtilTest的testOffset中报如下错误：
         * Cannot deserialize; nested exception is org.springframework.core.serializer.support.SerializationFailedException: Failed to deserialize payload.
         */
        redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplatek (JedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringRedisTemplate;
    }

}
