package com.bj;

import com.bj.spring.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/5/2 18:14
 * @serial: ----- 变更时间 变更者 变更说明
 */
//@SpringBootApplication
@Slf4j
public class BJAppStart {
    public static void main(String[] args) {
        log.info("现在开始初始化容器");
        //SpringApplication.run(BJAppStart.class, args);
        ApplicationContext factory = new ClassPathXmlApplicationContext("/beans/beans.xml");
        log.info("容器初始化成功");
        //得到product，并使用
        Product product = factory.getBean("product",Product.class);
        log.info(product.toString());

        log.info("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}
