package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.test04.Student.eat(..)) && args(food)")
    public void beforeEat(JoinPoint jp, String food) {
        System.out.println("[AOP] 먹을 준비 완료: " + food);
    }
}