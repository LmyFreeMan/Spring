package com.spring.test;

import com.spring.generic.di.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Generic {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("generic-di.xml");
        UserService userService= (UserService) ctx.getBean("userService");
        userService.add();
    }
}