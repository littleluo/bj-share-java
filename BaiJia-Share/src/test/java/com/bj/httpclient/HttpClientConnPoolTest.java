package com.bj.httpclient;

import org.junit.Test;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/4/11 0:10
 * @serial: ----- 变更时间 变更者 变更说明
 */
public class HttpClientConnPoolTest {

    @Test
    public void testGet(){
        for (int i = 0; i < 1; i++){
            HttpClientFactory.getInstance().doGet("http://127.0.0.1:9092/learn/product/get/12");
        }

    }
}
