package com.soren.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {

    @After("execution(* com.soren.service.BookServiceImpl.findAll(..))")
    public void afterFindAll(JoinPoint joinPoint){
        System.out.println("Sau khi ket thuc ham : "+joinPoint.getSignature().getName());
    }
}
