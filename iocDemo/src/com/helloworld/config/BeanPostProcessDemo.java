package com.helloworld.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @author byJiang
 * @title BeanPostProcessDemo
 * @date 2019/12/30
 **/
public class BeanPostProcessDemo implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before initialization-------------" +beanName +"-----------------");
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after initialization-------------" +beanName +"-----------------");
        return bean;
    }
}
