package com.test05;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.test05.Student.*(..))")
    public void beforeAllStudentMethods() {
        System.out.println("[AOP] 학생용 AOP 적용");
    }
}