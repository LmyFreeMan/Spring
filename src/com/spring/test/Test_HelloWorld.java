package com.spring.test;

import com.spring.beans.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

public class Test_HelloWorld {
    public static void main(String[] args) {
        //1.创建Spring的IOC容器对象
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContent.xml");
        //2.从IOC获取bean实例(通过id),要求ioc容器必须有一个该类型的bean
        HelloWorld helloWorld= (HelloWorld) ctx.getBean("helloWorld");
        //3.调用hello方法
        helloWorld.hello();
    }
}