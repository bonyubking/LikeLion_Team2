package com.mydb.core;
import org.aspectj.lang.JoinPoint;

public class LogAspect {

    public void before(JoinPoint jp) {
        System.out.println("[AOP] Before: " + jp.getSignature().getName());
    }

    public void after(JoinPoint jp) {
        System.out.println("[AOP] After: " + jp.getSignature().getName());
    }
}
