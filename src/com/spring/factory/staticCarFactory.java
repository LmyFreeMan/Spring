package com.spring.factory;
import java.util.HashMap;
import java.util.Map;

//静态工厂方法:直接调用一个类的静态方法就可以返回bean实例
public class staticCarFactory {
    private static Map<String,Car> cars=new HashMap<>();
    static {
        cars.put("audi",new Car("audi",300000));
        cars.put("ford",new Car("ford",400000));
    }
    public static Car getCar(String name){
        return cars.get(name);
    }

}