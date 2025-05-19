package com.test01;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.test02.Student.classWork(..))")
    public void beforeStudy() {
        System.out.println("[AOP] 공부 시작합니다.");
    }
}
