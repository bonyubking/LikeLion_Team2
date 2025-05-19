package com.test04;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect{
		
		@Before("execution(public void com.test03.*.classwork(..))")
		public void before(JoinPoint joinPoint) {
			System.out.println("[AOP] 줌인 합니다 출석 확인");
		}
		
		

			
		@AfterThrowing(pointcut = "execution(public void com.test03.*.classWork(..))" , throwing ="e")	
		public void throwing(JoinPoint joinPoint, Throwable e) {
			System.out.println("[aop]] 학습중 오류발생");
		}
				

		
		@After("execution(public void com.test03.*.classWork(..))")	
		public void after(JoinPoint joinPoint) {			
			System.out.println("[AOP] 줌 로그아웃 ");
		}
		
		
	}
		 
		 

