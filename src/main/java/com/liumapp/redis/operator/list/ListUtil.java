package com.liumapp.redis.operator.list;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 一个Key对应一个列表
 * Created by liumapp on 11/13/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class ListUtil {

    @Resource (name = "redisTemplate")
    private ListOperations<String , Object> listOps;

    /**
     * 返回存储在键中的列表的指定元素
     * 偏移开始和停止是基于零的索引
     * 其中0是列表的第一个元素（列表的头部）
     * 1是下一个元素
     * @param key Redis-key
     * @param start start
     * @param end end
     * @return return
     */
    public List<Object> range(String key , long start , long end) {
        return listOps.range(key , start , end);
    }

    /**
     * 修剪现有列表
     * 使其只包含指定的指定范围的元素
     * 起始和停止都是基于0的索引
     * @param key Redis-key
     * @param start start
     * @param end end
     */
    public void trim(String key , long start , long end) {
        listOps.trim(key , start , end);
    }

    /**
     * 返回存储在键中的列表的长度
     * 如果键不存在 则将其解释为空列表 并返回0
     * 当key存储的值不是列表时返回错误
     * @param key Redis-key
     * @return return
     */
    public Long size(String key) {
        return listOps.size(key);
    }

    /**
     * 将所有指定的值插入存储在键的列表的头部
     * 如果键不存在 则在执行推送操作之前将其创建为空列表
     * 从左边插入
     * 返回的结果为推送操作后的列表的长度
     * @param key Redis-key
     * @param value Redis-value
     * @return return
     */
    public Long leftPush(String key , Object value) {
        return listOps.leftPush(key , value);
    }

    /**
     * 把value值放到key对应列表中pivot值的左面
     * 如果pivot值存在的话
     * @param key Redis-key
     * @param pivot pivot object
     * @param value Redis-value
     * @return return
     */
    public Long leftPush(String key , Object pivot , Object value) {
        return listOps.leftPush(key , pivot , value);
    }

    /**
     * 弹出最左边的元素
     * 弹出之后该值在列表中将不复存在
     * @param key Redis-key
     * @return return
     */
    public Object leftPop(String key) {
        return listOps.leftPop(key);
    }

    /**
     * 移出并获取列表的第一个元素
     * 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
     * @param key Redis-key
     * @param timeout
     * @param unit
     * @return return
     */
    public Object leftPop(String key , Long timeout , TimeUnit unit) {
        return listOps.leftPop(key , timeout , unit);
    }

    /**
     * 批量把一个集合插入到列表中
     * @param key Redis-key
     * @param value Redis-value
     * @return return
     */
    public Long leftPushAll(String key , Collections value) {
        return listOps.leftPushAll(key , value);
    }

    /**
     * 批量作推元素
     * @param key 节点的key
     * @param values 多个值
     * @return long index
     */
    public Long leftPushAll(String key , String... values ) {
        return listOps.leftPushAll(key , values);
    }

    /**
     * 只有存在key对应的列表才能将这个value值插入到key所对应的列表中
     * @param key Redis-key
     * @param value Redis-value
     * @return return
     */
    public Long leftPushIfPresent(String key , Object value) {
        return listOps.leftPushIfPresent(key , value);
    }

    /**
     * 将所有指定的值插入存储在键的列表的头部
     * 如果键不存在 则在执行推送操作之前将其创建为空列表
     * 从右边插入
     * @param key Redis-key
     * @param value Redis-value
     * @return return
     */
    public Long rightPush(String key , Object value) {
        return listOps.rightPush(key , value);
    }

    /**
     * 把value值放到key对应列表中pivot值的右面
     * 如果pivot值存在的话
     * @param key Redis-key
     * @param pivot
     * @param value Redis-value
     * @return return
     */
    public Long rightPush(String key , Object pivot , Object value) {
        return listOps.rightPush(key , pivot , value);
    }

    /**
     * 弹出最右边的元素
     * 弹出之后该值在列表中将不复存在
     * @param key Redis-key
     * @return return
     */
    public Object rightPop(String key) {
        return listOps.rightPop(key);
    }

    /**
     * 移出并获取列表的最后一个元素
     * 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止
     * @param key Redis-key
     * @param timeout limited time
     * @param unit UnitTime
     * @return return
     */
    public Object rightPop(String key , Long timeout , TimeUnit unit) {
        return listOps.rightPop(key , timeout , unit);
    }

    /**
     * 批量插入列表
     * @param key Redis-key
     * @param value Redis-value
     * @return return
     */
    public Long rightPushAll(String key , Collections value) {
        return listOps.rightPushAll(key , value);
    }

    /**
     * 只有存在key对应的列表才能将这个value值插入到key所对应的列表中
     * @param key Redis-key
     * @param value Redis-value
     * @return return
     */
    public Long rightPushIfPresent(String key , Object value) {
        return listOps.rightPushIfPresent(key , value);
    }

    /**
     * 在列表中index的位置设置value值
     * @param key Redis-key
     * @param index list-index
     * @param value Redis-value
     */
    public void set(String key , long index , Object value) {
        listOps.set(key , index , value);
    }

    /**
     * 从存储在键中的列表中删除等于值的元素的第一个计数事件
     * count bg 0 从头到尾查找等于value的元素 并删除
     * count lw 0 从尾到头查找等于value的元素 并删除
     * count equal 0 删除等于value的所有元素
     * @param key Redis-key
     * @param count count-number
     * @param value Redis-value
     * @return return
     */
    public Long remove(String key , Long count , Object value) {
        return listOps.remove(key , count , value);
    }

    /**
     * 根据下标获取列表中的值
     * 下标是从0开始的
     * @param key Redis-key
     * @param index list-index
     * @return return
     */
    public Object index(String key , Long index) {
        return listOps.index(key , index);
    }

    /**
     * 用于移除列表的最后一个元素
     * 并将该元素添加到另一个列表并返回
     * @param sourceKey source list key
     * @param destinationKey destination list key
     * @return return
     */
    public Object rightPopAndLeftPush(String sourceKey , String destinationKey) {
        return listOps.rightPopAndLeftPush(sourceKey , destinationKey);
    }

    /**
     * 用于移除列表的最后一个元素
     * 并将该元素添加到另一个列表并返回
     * 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止
     * @param sourceKey source list key
     * @param destinationKey destination list key
     * @param timeout limited time
     * @param unit TimeUnit
     * @return return
     */
    public Object rightPopAndLeftPush(String sourceKey , String destinationKey , Long timeout , TimeUnit unit) {
        return listOps.rightPopAndLeftPush(sourceKey , destinationKey , timeout , unit);
    }

}
