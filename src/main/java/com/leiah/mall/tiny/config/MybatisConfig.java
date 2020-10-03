package com.leiah.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Leiah
 * @Description: 用于配置需要动态生成的mapper接口的路径
 * @Date: 2020/9/5 13:56
 */
@Configuration
@MapperScan({"com.leiah.mall.tiny.mbg.mapper", "com.leiah.mall.tiny.dao"})
public class MybatisConfig {

}
