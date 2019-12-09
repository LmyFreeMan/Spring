package com.spring.beans;

public class HelloWorld {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public HelloWorld(String name) {
        System.out.println("有参构造器的值为"+name);
    }

    public HelloWorld() {
      System.out.println("我是无参数构造器");
    }

    public void hello(){
        System.out.println("hello,"+this.getName());
    }
}