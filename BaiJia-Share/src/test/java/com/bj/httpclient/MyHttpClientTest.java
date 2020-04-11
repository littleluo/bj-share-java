package com.bj.httpclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/4/11 10:17
 * @serial: ----- 变更时间 变更者 变更说明
 */
@Slf4j
public class MyHttpClientTest {
    private static HttpClient client;
    static {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(3000)
                .setSocketTimeout(5000).build();
        client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig)
                .build();
    }

    @Test
    public void testHttpClient()  {
        for (int i = 0; i < 5; i++) {
            String url = "http://127.0.0.1:9092/learn/product/get/12";
            HttpGet httpGet = new HttpGet(url);
            try {
                HttpResponse res = client.execute(httpGet);
            } catch (IOException e) {
                log.error("异常： ",e);
                return;
            }
        }
    }
}
