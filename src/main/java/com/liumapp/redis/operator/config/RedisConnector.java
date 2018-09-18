package com.liumapp.redis.operator.config;

import org.springframework.stereotype.Component;

/**
 * file RedisConnector.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/9/18
 */
public class RedisConnector {

    private String hostName;

    private Integer port;

    private String password;

    private Integer dbIndex;

    public RedisConnector() {
    }

    public RedisConnector(String hostName, Integer port, String password, Integer dbIndex) {
        this.hostName = hostName;
        this.port = port;
        this.password = password;
        this.dbIndex = dbIndex;
    }

    public String getHostName() {
        return hostName;
    }

    public RedisConnector setHostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public RedisConnector setPort(Integer port) {
        this.port = port;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RedisConnector setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getDbIndex() {
        return dbIndex;
    }

    public RedisConnector setDbIndex(Integer dbIndex) {
        this.dbIndex = dbIndex;
        return this;
    }

    @Override
    public String toString() {
        return "RedisConnector{" +
                "hostName='" + hostName + '\'' +
                ", port=" + port +
                ", password='" + password + '\'' +
                ", dbIndex=" + dbIndex +
                '}';
    }
}
