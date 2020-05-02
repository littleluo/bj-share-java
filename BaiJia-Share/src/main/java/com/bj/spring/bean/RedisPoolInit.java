package com.bj.spring.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/5/2 19:04
 * @serial: ----- 变更时间 变更者 变更说明
 */
@Configuration
@Slf4j
public class RedisPoolInit  {

    /**
     * 初始化Redis 连接池
     * @return
     */
   // @Bean(initMethod = "init", name = "db1_redis", destroyMethod = "destroy")
    @PostConstruct
    @Bean(name = "db1_redis")
    public BJRedis initJedisPool(){
        log.info("开始初始化redis连接池....");
        BJRedis bjRedis = new BJRedis();
        bjRedis.init();
        return bjRedis;
    }
}
