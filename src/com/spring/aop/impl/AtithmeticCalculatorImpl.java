package com.spring.aop.impl;

import org.springframework.stereotype.Component;

@Component
public class AtithmeticCalculatorImpl implements AtithmeticCalculator {
    @Override
    public int add(int i, int j) {
        System.out.println("The method add begin with");
        int result=i+j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result=i-j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result=i*j;
        return result;

    }

    @Override
    public int div(int i, int j) {
       int result= i/j;
        return result;
    }
}