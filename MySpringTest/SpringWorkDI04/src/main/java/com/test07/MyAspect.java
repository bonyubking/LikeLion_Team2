package com.test07;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.test07.Student.*Work(..))")
    public void beforeAllStudentMethods() {
        System.out.println("[AOP] 작업 시작");
    }
}