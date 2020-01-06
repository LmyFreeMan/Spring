package com.spring.test;
import com.spring.spel.Address;
import com.spring.spel.Car;
import com.spring.spel.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test_Spel {
    public static void main(String[] args) {
        //1.创建Spring的IOC容器对象
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-spel.xml");
        Address address= (Address) ctx.getBean("address");
        System.out.println(address);

        Car car= (Car) ctx.getBean("car");
        System.out.println(car);

        Person person= (Person) ctx.getBean("person");
        System.out.println(person);
    }
}