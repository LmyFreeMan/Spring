package com.spring.test;

import com.spring.factory.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Factory {
    public static void main(String[] args) {
      ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-factory.xml");
      Car car= (Car) ctx.getBean("car_factory");
      System.out.println(car);

      Car car1= (Car) ctx.getBean("car_instance");
      System.out.println(car1);

    }
}