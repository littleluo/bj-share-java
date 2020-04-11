package com.bj.httpclient;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/4/9 22:54
 * @serial: ----- 变更时间 变更者 变更说明
 */
public class HttpClientFactory {
    private enum HttpClientEnumSingleton{
        /**
         * 相当于是HttpClientEnumSingleton构造函数
         */
        singletonFactory;
        private HttpClientConnPool instance;
        HttpClientEnumSingleton(){//枚举类的构造方法在类加载是被实例化
            instance = new HttpClientConnPool();
        }
        public HttpClientConnPool getInstance(){
            return instance;
        }
    }
    public static HttpClientConnPool getInstance(){
        //通过内部封装，可以不暴露内部实现
        return HttpClientEnumSingleton.singletonFactory.getInstance();
    }
}
