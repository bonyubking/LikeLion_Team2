package com.test10;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	
	public void before(JoinPoint joinpoint) {
		
		System.out.println("[AOP] XML AOP 적용됨 ");
	}

	

}
