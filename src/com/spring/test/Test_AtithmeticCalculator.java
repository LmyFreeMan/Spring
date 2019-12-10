package com.spring.test;

import com.spring.aop.helloworld.ArithmeticCalculatorLoggingProxy;
import com.spring.aop.helloworld.AtithmeticCalculator;
import com.spring.aop.helloworld.AtithmeticCalculatorImpl;

public class Test_AtithmeticCalculator {
    public static void main(String[] args) {
        AtithmeticCalculator target=new AtithmeticCalculatorImpl();
        AtithmeticCalculator proxy=new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
        int result=proxy.add(1,2);
        System.out.println(result);
      //  AtithmeticCalculator target=new


    }
}