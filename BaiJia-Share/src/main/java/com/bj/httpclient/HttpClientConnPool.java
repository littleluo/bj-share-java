package com.bj.httpclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/4/9 22:57
 * @serial: ----- 变更时间 变更者 变更说明
 */
@Slf4j
public class HttpClientConnPool {

    private CloseableHttpClient client = null;
    private RequestConfig requestConfig = null;
    //响应处理器
    private static ResponseHandler<String> responseHandler = null;
    HttpClientConnPool() {
        requestConfig =RequestConfig.custom()
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(3000)
                .setSocketTimeout(5000).build();
        initHttpClient();
        responseHandler = new BasicResponseHandler();
    }

    public void doGet(String url) {
        HttpGet get = new HttpGet(url);
        try {
            if (Objects.isNull(url)) {
                throw new RuntimeException("请求连接不能为空");
            }

            // 很奇怪，使用CloseableHttpClient来请求澎湃新闻的首页，GTE请求也必须加上下面这个Header，但是使用HTTPClient则不需要
            //get.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
        /*    HttpResponse response = client.execute(get);
            String res = EntityUtils.toString(response.getEntity());
            log.info("请求结果==== " + res);
*/
            String result = client.execute(get, responseHandler);
            log.info("请求结果==== " + result);
        } catch (IOException e) {
            log.error("请求异常==== " + e);
        }
    }

    public void doPost(String url, String charset) {
        HttpPost post = new HttpPost(url);
        try {
            post.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("commentId", "18718372"));
            post.setEntity(new UrlEncodedFormEntity(params, charset));
            HttpResponse response = client.execute(post);
            String res = EntityUtils.toString(response.getEntity());
            log.info("请求结果==== " + res);
        } catch (UnsupportedEncodingException e) {
            log.error("请求异常==== " + e);
        } catch (ClientProtocolException e) {
            log.error("请求异常==== " + e);
        } catch (IOException e) {
            log.error("请求异常==== " + e);
        }
    }

    private void initHttpClient(){
        client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig)
                .build();
    }
}
