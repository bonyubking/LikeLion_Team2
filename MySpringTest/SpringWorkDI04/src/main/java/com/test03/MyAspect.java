package com.test03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@AfterThrowing(pointcut = "execution(public void com.test03.*.homework(..))" , throwing ="e")	
	public void throwing(JoinPoint joinPoint, Throwable e) {
		System.out.println("[aop] 과제 오류 발생: 파일 오류");
	}
		
}
