package com.bj.spring.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/5/2 21:42
 * @serial: ----- 变更时间 变更者 变更说明
 */
@Slf4j
public class BJBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public BJBeanFactoryPostProcessor() {
        super();
        log.info("这是BeanFactoryPostProcessor实现类构造器！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0)
            throws BeansException {
        log.info("BeanFactoryPostProcessor调用postProcessBeanFactory方法");
        BeanDefinition bd = arg0.getBeanDefinition("product");
        bd.getPropertyValues().addPropertyValue("name", "麦香鸡");
    }
}
