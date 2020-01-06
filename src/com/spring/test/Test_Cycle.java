package com.spring.test;

import com.spring.cycle.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Cycle {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("bean-cycle.xml");
        Car car= (Car) ctx.getBean("car");
        System.out.println(car);
        // 关闭ioc容器
        ctx.close();

    }
}