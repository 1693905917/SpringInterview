package com.itheima.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//3.Aware接口
public class User implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {
    //1.构造函数
    public User() {
        System.out.println("User的构造方法执行了.........");
    }
    //2.依赖注入1
    private String name ;
    //2.依赖注入2
    @Value("张三")
    public void setName(String name) {
        System.out.println("setName方法执行了.........");
    }

    @Override
    //3.Aware接口
    public void setBeanName(String name) {
        System.out.println("setBeanName方法执行了.........");
    }

    @Override
    //3.Aware接口
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory方法执行了.........");
    }

    @Override
    //3.Aware接口
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext方法执行了........");
    }

    @PostConstruct
    //5.自定义的初始化方法
    public void init() {
        System.out.println("init方法执行了.................");
    }

    @Override
    //5.InitializingBean接口下的初始化方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet方法执行了........");
    }

    @PreDestroy
    //7.销毁方法
    public void destory() {
        System.out.println("destory方法执行了...............");
    }
}