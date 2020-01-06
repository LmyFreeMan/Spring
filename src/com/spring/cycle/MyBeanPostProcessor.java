package com.spring.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    /*

   public Object postProcessBeforeInitialization(Object bean, String beanName) init-method方法之前被调用
   public Object postProcessAfterInitialization(Object bean, String beanName)  init-method方法之后被调用
   bean:bean实例本身
   beanName:IOC容器配置的bean的名字
   */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("22");
        System.out.println("postProcessBeforeInitialization:"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization:"+beanName);
        Car car=new Car();
        car.setBrand("Ford");
        return car;
    }
}