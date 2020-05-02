package com.bj.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * <pre>
 * Company:
 * Title:
 * 类描述:
 * </pre>
 *
 * @author 罗会枫
 * @version 1.0
 * @since: 2020/5/2 21:45
 * @serial: ----- 变更时间 变更者 变更说明
 */
public class Product implements BeanFactoryAware, BeanNameAware,
        InitializingBean, DisposableBean {

    private String name;
    private String feature;
    private int id;

    private BeanFactory beanFactory;
    private String beanName;

    public Product() {
        System.out.println("【构造器】调用Product的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】注入属性name");
        this.name = name;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        System.out.println("【注入属性】注入属性feature");
        this.feature = feature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("【注入属性】注入属性id");
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", feature="
                + feature + "]";
    }

    // 这是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        System.out
                .println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = arg0;
    }

    // 这是BeanNameAware接口方法
    @Override
    public void setBeanName(String arg0) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = arg0;
    }

    // 这是InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out
                .println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    // 这是DiposibleBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void initProduct() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void destroyProduct() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }
}
