package com.spring.test;

import com.spring.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_AutoWire  {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("autowire.xml");
        Person person= (Person) ctx.getBean("person");
        System.out.println(person);
    }
}