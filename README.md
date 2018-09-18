# redis-operator
using redis in SpringBoot , with 5 kinds of data structure.

项目正在开发中，请勿使用

## 如何使用

首先通过Maven引入项目：

    <dependency>
        <groupId>com.liumapp.redis</groupId>
        <artifactId>redis-operator</artifactId>
        <version>v1.0.0</version>
    </dependency>
    
然后在yaml文件中进行Redis服务的配置：

    liumapp:
      redis:
        hostName: localhost
        port: 6379
        password: adminadmin
        dbIndex: 0
        
引入后在springboot的启动类上加上：

    @Import(RedisOperatorMain.class)        
   

## 注意事项

### 数据类型

Redis一共支持五种数据类型，每一种存储的值及读写的能力如下表所示：

类型     | 存储的值 | 读写能力
:---------|:---|:---
String    | a. 字符串 <br> b. 整数 <br> c. 浮点数 | a. 对整个字符串或者字符串的其中一部分执行操作 <br> b. 整数和浮点数执行自增或自减 
List      | 一个链表，链表上的每个节点都包含了一个字符串   | a. 从链表的两端推入或者弹出元素 <br> b. 根据偏移量对链表进行修剪(trim) <br> c. 读取单个或者多个元素 <br> d. 根据值来查找或者移除元素
Set       | 包含字符串的无序收集器(unorderedcollection)，并且被包含的每个字符串都是独一无二的、各不相同 | a. 添加、获取、移除单个元素 <br> b. 检查一个元素是否存在于某个集合中 <br> c. 计算交集、并集、差集 <br> d. 从集合里随机获取元素
Hash      | 包含键值对的无序散列表 | a. 添加、获取、移除单个键值对 <br> b. 获取所有键值对
Zset      | 字符串成员(member)与浮点数分值(score)之间的有序映射，元素的排列顺序由分值的大小决定 | a. 添加、获取、删除单个元素 <br> b. 根据分值范围(range)或者成员来获取元素

### RedisTemplate

RedisTemplate是Spring对Redis执行操作的一个封装。

我们将通过它来操作上述五种类型的数据结构，具体类型如下:

```
redisTemplate.opsForValue();//操作字符串
redisTemplate.opsForHash();//操作hash
redisTemplate.opsForList();//操作list
redisTemplate.opsForSet();//操作set
redisTemplate.opsForZSet();//操作有序set
```

操作字符串的工具类，封装在com.liumapp.redis.operator.string下。

操作Hash的工具类，封装在com.liumapp.redis.operator.hash下。

操作List的工具类，封装在com.liumapp.redis.operator.list下。

操作Set的工具类，封装在com.liumapp.redis.operator.set下。

操作Zset的工具类，封装在com.liumapp.redis.operator.zset下。

测试Demo请见test目录。

### StringRedisTemplate

* StringRedisTemplate继承于RedisTemplate

* 数据并不是共通的，StringRedisTemplate管理的数据，RedisTemplate是拿不到的。同理，StringRedisTemplate也拿不到RedisTemplate下面的数据。

* StringRedisTemplate默认采用的是String的序列化策略来保存key和value，而RedisTemplate默认采用的是JDK的序列化策略。

* 这个项目几乎引用的全部都是RedisTemplate

[帮助链接](http://www.jianshu.com/p/7bf5dc61ca06)


## 注意事项

Spring Boot2.x系列默认使用的Redis连接为Lettuce，而非Jedis

所以比较习惯使用Jedis的小伙伴们，请一定记得排除Lettuce依赖，并额外引入Jedis依赖

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-redis</artifactId>
      <exclusions>
        <exclusion>
         <groupId>io.lettuce</groupId>
         <artifactId>lettuce-core</artifactId>
        </exclusion>
      </exclusions>            
    </dependency>        
    <dependency>
      <groupId>redis.clients</groupId>
      <artifactId>jedis</artifactId>
    </dependency> 
    
否则直接使用Jedis将会报以下异常：

    Caused by: java.lang.ClassNotFoundException: redis.clients.jedis.JedisPoolConfig
    
        