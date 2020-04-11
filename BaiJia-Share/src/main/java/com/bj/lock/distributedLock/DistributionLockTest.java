package com.bj.lock.distributedLock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/4/11 23:25
 * @serial: ----- 变更时间 变更者 变更说明
 */
@Slf4j
public class DistributionLockTest {
    /**
     * NX-Only set the key if it does not already exist.
     * XX -- Only set the key if it already exist.
     */
    private static final String SET_IF_NOT_EXIST = new String("NX");

    /**
     * EX|PX, expire time units: EX = seconds; PX = milliseconds
     */
    private static final String SET_WITH_EXPIRE_TIME = new String("PX");

    private static final String LOCK_OK = new String("OK");
    private static final Long RELEASE_SUCCESS = new Long(1);

    private static final ThreadLocal<String> thdLocalLockValue = new ThreadLocal<>();

    public static void main(String[] args) {
        String lockKey = "LF-TEST:DISTRIBUTION:LOCK";
        int maxThread = 1000;
        ExecutorService fixedCacheThreadPool = Executors.newFixedThreadPool(maxThread);
        CountDownLatch cdLatch = new CountDownLatch(maxThread);
        long start = System.currentTimeMillis();
        for (int i = 0; i < maxThread; i++) {
            fixedCacheThreadPool.execute(() -> {
                if(Objects.isNull(thdLocalLockValue.get())){
                    thdLocalLockValue.set(StringUtils.replace(UUID.randomUUID().toString(), "-", ""));
                }
                RedisUtil redisUtil = RedisUtil.getInstance();
                Jedis jedis = redisUtil.getJedis();
                try {
                    if(tryGetLock(jedis, lockKey, thdLocalLockValue.get(), 200)){
                        TimeUnit.MILLISECONDS.sleep(100);
                        releaseLock(jedis, lockKey, thdLocalLockValue.get());
                    }
                } catch (Exception ex) {
                    log.error("获取或释放锁有误：", ex);
                } finally {
                    if (null != jedis) {
                        //归还连接
                        jedis.close();
                    }
                    thdLocalLockValue.remove();
                }
                cdLatch.countDown();
            });
        }
        try {
            cdLatch.await(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("cdLatch 异常：", e);
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("共耗时:" + end + "毫秒");
    }

    /**
     * 尝试获得锁
     *
     * @param jedis
     * @param lockKey
     * @param value
     * @param milliseconds（毫秒）
     * @return
     */
    private static Boolean tryGetLock(Jedis jedis, String lockKey, String value, int milliseconds) {
        String result = jedis.set(lockKey, value, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, milliseconds);
        if (LOCK_OK.equals(result)) {
            log.info("获得锁，线程名称==" + Thread.currentThread().getName());
            return true;
        }
        log.info("未获得锁，线程名称==" + Thread.currentThread().getName());
        return false;
    }

    /**
     * 释放锁
     *
     * @param jedis
     * @param lockKey
     * @param value
     * @return
     */
    private static Boolean releaseLock(Jedis jedis, String lockKey, String value) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Long result = (Long) jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(value));
        if (RELEASE_SUCCESS.equals(result)) {
            log.info("释放锁，线程名称==" + Thread.currentThread().getName());
            return true;
        }
        log.info("未释放锁，线程名称==" + Thread.currentThread().getName());
        return false;
    }
}
