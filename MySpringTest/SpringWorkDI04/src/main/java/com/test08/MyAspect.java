package com.test08;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.test08.Student.study(..))")
    public void beforeStudy() {
        System.out.println("[AOP] 수업 준비");
    }
    
    @After("execution(* com.test08.Student.study(..))")
    public void afterStudy() {
        System.out.println("[AOP] 수업 종료");
    }
}