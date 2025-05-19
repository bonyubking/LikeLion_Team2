package com.test06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @After("execution(* com.test06.Student.calculate(..))")
    public void afterCalc(JoinPoint jp) {
        System.out.println("[AOP] 정수 반환 완료");
    }
}