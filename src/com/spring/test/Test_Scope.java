package com.spring.test;

import com.spring.autowire.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Scope {
    public static void main(String[] args) {
        //1.创建Spring的IOC容器对象
        ApplicationContext ctx=new ClassPathXmlApplicationContext("scope.xml");
        //2.从IOC获取bean实例(通过id),要求ioc容器必须有一个该类型的bean
        Car car= (Car) ctx.getBean("car");
        System.out.println(car.toString());
    }
}