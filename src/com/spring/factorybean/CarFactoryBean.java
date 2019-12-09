package com.spring.factorybean;

import com.spring.factory.Car;
import org.springframework.beans.factory.FactoryBean;
//自定义的FactoryBean需要实现FactoryBean接口
public class CarFactoryBean implements FactoryBean<Car> {
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String brand;

    //返回bean的对象
    @Override
    public Car getObject() throws Exception {
        return new Car("BMW",5000000);
    }
    //返回bean的类型
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}