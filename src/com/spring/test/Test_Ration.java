package com.spring.test;

import com.spring.autowire.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Ration {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("relation.xml");
        Address address= (Address) ctx.getBean("address");
        System.out.println(address);

    }
}