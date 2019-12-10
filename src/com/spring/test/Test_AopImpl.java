package com.spring.test;


import com.spring.aop.impl.AtithmeticCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_AopImpl {
    public static void main(String[] args) {
        //1.创建spring的ioc容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("aop.xml");
        //2.从ioc容器获取bean实例
        AtithmeticCalculator atithmeticCalculator=ctx.getBean(AtithmeticCalculator.class);
        // 3.使用bean
        int result=atithmeticCalculator.add(3,6);
        System.out.println("result="+result);
        System.out.println(atithmeticCalculator.div(10,2));
    }
}