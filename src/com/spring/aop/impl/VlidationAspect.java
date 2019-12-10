package com.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class VlidationAspect {
    @Before("execution(public int com.spring.aop.impl.AtithmeticCalculator.*(..))")
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("validate:"+ Arrays.asList(joinPoint.getArgs()));
    }
}