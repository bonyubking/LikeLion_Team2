package com.test09;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("@annotation(com.test09.LogExecution)")
    public void beforeStudy() {
        System.out.println("[AOP] 로깅 처리");
    }
}