package com.test02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @After("execution(* com.test02.Student.getScore(..))")
    public void afterStudy() {
        System.out.println("[AOP] 점수 저장 완료.");
    }
}
