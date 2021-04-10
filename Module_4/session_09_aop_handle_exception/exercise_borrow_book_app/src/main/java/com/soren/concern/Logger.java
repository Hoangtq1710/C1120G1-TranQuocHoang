package com.soren.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {

    @After("execution(* com.soren.controller.BookController.getHome(..))")
    public void afterGetHome(JoinPoint joinPoint){
        System.err.println("Sau khi ket thuc ham getHome : "+joinPoint.getSignature().getName());
    }

    @After("execution(* com.soren.controller.BookController.borrowBook(..))")
    public void afterBorrowBook(JoinPoint joinPoint) {
        System.err.println("Sau khi goi ham : " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.soren.controller.BookController.givebackBook(..))")
    public void afterGivebackBook(JoinPoint joinPoint) {
        System.err.println("Sau khi goi ham : " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.soren.service.BookServiceImpl.decreasingBookQuantity(..))")
    public void afterThrowingException(JoinPoint joinPoint) {
        System.err.println("Sau khi throw Exception : " + joinPoint.getSignature().getName());
    }
}
