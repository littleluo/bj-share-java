package com.bj;

import com.bj.spring.bean.Product;
import com.bj.spring.bean.scope.TransferRecords;
import com.bj.spring.bean.scope.TransferService;
import com.bj.spring.bean.scope.TransferServiceImpl;
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
        // SpringApplication.run(BJAppStart.class, args);
/*        log.info("现在开始初始化容器");
        ApplicationContext factory = new ClassPathXmlApplicationContext("/beans/beans.xml");
        log.info("容器初始化成功");
        //得到product，并使用
        Product product = factory.getBean("product",Product.class);
        log.info(product.toString());

        log.info("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();*/

        ApplicationContext context = new ClassPathXmlApplicationContext("/beans/transferBeans.xml");
        log.info("开始请求transferService");
        TransferService transferService_1 = context.getBean(TransferServiceImpl.class);
        TransferService transferService_2 = context.getBean(TransferServiceImpl.class);
        log.info("transferService_1 == transferService_2 ? 结果是：{}", transferService_1.equals(transferService_2));
        log.info("请求transferService结束");
    }
}
