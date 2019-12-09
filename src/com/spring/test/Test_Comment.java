package com.spring.test;

import com.spring.annotation.TestObject;
import com.spring.annotation.controller.UserController;
import com.spring.annotation.repository.UserRepository;
import com.spring.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Comment {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean-annotation.xml");
        TestObject to= (TestObject) ctx.getBean("testObject");
        System.out.println(to);
        UserController userController= (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.execute();
        UserRepository userRepository= (UserRepository) ctx.getBean("UserRepository");
        System.out.println(userRepository);
        UserService userService= (UserService) ctx.getBean("userService");
        System.out.println(userService);

    }

}