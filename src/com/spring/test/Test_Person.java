package com.spring.test;

import com.spring.beans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Person {
    public static void main(String[] args) {
        //1.创建Spring的IOC容器对象
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContent.xml");
        //2.从IOC获取bean实例(通过id),要求ioc容器必须有一个该类型的bean
        Person person= (Person) ctx.getBean("person");
        System.out.println(person);

        Person person_p= (Person) ctx.getBean("person_p");
        System.out.println(person_p);
    }
}