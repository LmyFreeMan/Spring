package com.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Test_Properties {
    public static void main(String[] args) throws SQLException {
        //1.创建Spring的IOC容器对象
        ApplicationContext ctx=new ClassPathXmlApplicationContext("properties.xml");
        //2.从IOC获取bean实例(通过id),要求ioc容器必须有一个该类型的bean
        DataSource dataSource= (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource.getConnection());

    }
}