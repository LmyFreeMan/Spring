package com.spring.test;

import com.spring.collections.DataSource;
import com.spring.collections.Person_List;
import com.spring.collections.Person_Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Collections {

    public static void main(String[] args) {
        //1.创建Spring的IOC容器对象
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContents.xml");
        //2.从IOC获取bean实例(通过id),要求ioc容器必须有一个该类型的bean
        //测试list
        Person_List person= (Person_List) ctx.getBean("person_list");
        System.out.println(person);
        //测试map
        Person_Map person_map= (Person_Map) ctx.getBean("person_map");
        System.out.println(person_map);
        //测试properties
        DataSource dataSource=ctx.getBean(DataSource.class);
        System.out.println(dataSource.getProperties());

    }
}