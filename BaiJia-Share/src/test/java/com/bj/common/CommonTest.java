package com.bj.common;

import com.bj.httpclient.HttpClientConnPool;
import com.bj.httpclient.HttpClientFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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
 * @since: 2020/4/11 9:55
 * @serial: ----- 变更时间 变更者 变更说明
 */
@Slf4j
public class CommonTest {

    @Test
    public void testMulti(){
        int maxThread = 100;
        ExecutorService fixedCacheThreadPool = Executors.newFixedThreadPool(maxThread);
        CountDownLatch cdLatch = new CountDownLatch(maxThread);
        long start = System.currentTimeMillis();
        Set<HttpClientConnPool> sets = new HashSet<>();
        for (int i = 0; i < maxThread; i++) {
            fixedCacheThreadPool.execute(() -> {
              /*  HttpClientConnPool httpClientConnPool =  HttpClientFactory.getInstance();
                sets.add(httpClientConnPool);
                httpClientConnPool.doGet("http://127.0.0.1:9092/learn/product/get/12");*/
              //TODO 此处写定时任务的方法
                cdLatch.countDown();
            });
        }
        try {
            cdLatch.await(30, TimeUnit.SECONDS);
            for (HttpClientConnPool set : sets) {
                System.out.println(set.getClass().getName());
            }
        } catch (InterruptedException e) {
            log.error("cdLatch 异常：", e);
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("共耗时:" + end + "毫秒");
    }
}
