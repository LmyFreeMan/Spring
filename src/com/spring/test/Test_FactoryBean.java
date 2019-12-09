package com.spring.test;

import com.spring.factory.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_FactoryBean {
    public static void main(String[] args) {
        //1.创建Spring的IOC容器对象
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beanfactory.xml");
        Car car= (Car) ctx.getBean("car");
        System.out.println(car);
    }
}