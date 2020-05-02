package com.bj.spring.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/5/2 17:32
 * @serial: ----- 变更时间 变更者 变更说明
 */
@Component
@Slf4j
public class DataSourcePasswordEncryptPostProcessor implements BeanPostProcessor {
    public DataSourcePasswordEncryptPostProcessor() {
        super();
        System.out.println("这是DataSourcePasswordEncryptPostProcessor实现类构造器！！");
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String name)
            throws BeansException {
       /* if(bean instanceof MySqlDataSource){
            MySqlDataSource ds = (MySqlDataSource)bean;
            String dsPassword = BJPropertiesConfig.getInstance().getValue(BJPropertiesConfig.DB_PWD);
            log.info("密文==={}", dsPassword);
            String dePassword = MD5Util.dencryptByMD5(dsPassword);
            log.info("解密结果==={}", dePassword);
            ds.setPassword(dePassword);
        }*/
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String name)
            throws BeansException {
        return bean;
    }
}
