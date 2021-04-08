package com.soren.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

@Aspect
public class Logger {

    @AfterReturning("execution(* com.soren.controller.CustomerController.getHome(..))")
    public void afterReturningFindAll(JoinPoint joinPoint){
        System.out.println( "Kết thúc hàm findAll\n " +
                            "Name : "+ joinPoint.getSignature().getName());
    }

    @Before("execution(* com.soren.service.impl.CustomerServiceImpl.findById(..))")
    public void beforeServiceImplFindById(JoinPoint joinPoint){
        System.out.println("Trước khi bắt đầu hàm FindById\n Name method : " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(public * com.soren.service..*.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint,Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
}
