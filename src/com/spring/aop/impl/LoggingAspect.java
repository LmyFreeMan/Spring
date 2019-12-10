package com.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//把这个类声明一个切面:需要把该类放到ioc容器中，再声明一个切面
@Order(2)
@Aspect
@Component
public class LoggingAspect {
    //定义一个方法,用于声明切入点表达式,一般地,该方法不需要添加其他代码
	//使用@Pointcut来引入切片表达式
    @Pointcut("execution(public int com.spring.aop.impl.*.*(..))")
    public void declareJointPointExpression(){

    }
    //声明该方法是一个前置通知:在目标方法开始之前执行
    @Before("declareJointPointExpression()")
    //所有方法都起作用
    //@Before("execution(public int com.spring.aop.impl.AtithmeticCalculator.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        List<Object> args= Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+methodName+"Begin with "+args);
    }
    //后置通知:在目标方法执行后(无论发生异常)，执行的通知
    //在后置通知中还不能访问目标方法执行的结果
    @After("execution(public int com.spring.aop.impl.*.*(int,int))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("The Method "+methodName+" ends");
    }
    //返回通知,再方法正常结束执行的代码，有返回值
    @AfterReturning(value = "execution(public int com.spring.aop.impl.*.*(int,int))",returning ="result")
    public void afterReturuing(JoinPoint joinPoint,Object result){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("The Method "+methodName+" ends with"+result);
    }
    //异常通知
    //在目标方法出现异常会执行的代码，可以访问到异常的对象，且可以指定在出现特定异常时在执行通知代码
    @AfterThrowing(value = "execution(public int com.spring.aop.impl.*.*(int,int))",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("The Method "+methodName+"occurs exception"+ex);
    }
    //坏绕通知需要携带ProceedingJoinPoint类型的参数
    //ProceedingJoinPoint是否执行目标方法,且环绕通知必须有返回值,返回值即目标方法的返回值
    @Around("execution(public int com.spring.aop.impl.*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pjd){
        Object result=null;
        String methodName = pjd.getSignature().getName();
       System.out.println("aroundMethod");
       //执行目标方法
        try {
            //前置通知
            System.out.println("进入前置通知");
            System.out.println("The method"+methodName + "begin with" + Arrays.asList(pjd.getArgs()));
           result=pjd.proceed();
           //后置通知
            System.out.println("进入后置通知");
            System.out.println("The method end with"+result);

        } catch (Throwable throwable) {
            //异常通知
            System.out.println("进入异常通知");
           System.out.println("The method occurs exception"+throwable);
        }
        //后置通知
        System.out.println("The method "+methodName + " ends");
        return result;
    }
}