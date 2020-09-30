package com.leiah.mall.tiny.service;

/**
 * @Author: Leiah
 * @Description: redis操作service，对象和数组都以json格式存储
 * @Date: 2020/9/12 9:43
 */
public interface RedisService {
    /**
    * @Description: 设置数据
    * @Param: [key, value]
    * @Return: void
    * @Date: 2020/9/12 9:45
    **/
    void set(String key, String value);

    /**
    * @Description: 获取数据
    * @Param: [key]
    * @Return: java.lang.String 
    * @Date: 2020/9/12 9:46
    **/
    String get(String key);

    /**
    * @Description: 设置超期时间
    * @Param: [key, expire]
    * @Return: boolean
    * @Date: 2020/9/12 9:47
    **/
    boolean expire(String key, long expire);

    /**
    * @Description: 输出数据
    * @Param: [key]
    * @Return: void
    * @Date: 2020/9/12 9:47
    **/
    void remove(String key);

    /**
    * @Description: 自增操作
    * @Param: [key, delta]
    * @Return: java.lang.Long
    * @Date: 2020/9/12 9:48
    **/
    Long increment(String key, long delta);
}
