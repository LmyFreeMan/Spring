package com.spring.cycle;
import jdk.management.resource.internal.inst.InitInstrumentation;
public class Car {
    public Car() {
        System.out.println("car's construcor,行号是5");
    }
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("setBrand");
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }

    public void  init(){
        System.out.println("init");
    }
    public void destory(){
        System.out.println("destory");
    }
}