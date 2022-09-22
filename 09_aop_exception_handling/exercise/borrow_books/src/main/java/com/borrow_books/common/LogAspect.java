package com.borrow_books.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    int count = 0;

    @Pointcut("within(com.borrow_books.controller.*)")
    public void allMethod() {
    }

    @After("allMethod()")
    public void getHere(JoinPoint joinPoint) {
        count++;
        System.out.println("Method name: " + joinPoint.getSignature().getName() + " called " + count + " times");
    }

    @Pointcut("execution(* com.borrow_books.controller.BookController.getListBook(..))")
    public void bookList() {
    }

    @After("bookList()")
    public void list(JoinPoint joinPoint) {
        count++;
        System.out.println("Method name: " + joinPoint.getSignature().getName() + " called " + count + " times");
    }

    @Pointcut("execution(* com.borrow_books.controller.BookController.borrowBooks(..))")
    public void borrowSuccess() {
    }

    @After("borrowSuccess()")
    public void borrow(JoinPoint joinPoint) {
        count++;
        System.out.println("Method name: " + joinPoint.getSignature().getName() + " called " + count + " times");
    }

    @Pointcut("execution(* com.borrow_books.controller.BookController.returnBooks(..))")
    public void returnSuccess() {
    }

    @After("returnSuccess()")
    public void returnBook(JoinPoint joinPoint) {
        count++;
        System.out.println("Method name: " + joinPoint.getSignature().getName() + " called " + count + " times");
    }
}
