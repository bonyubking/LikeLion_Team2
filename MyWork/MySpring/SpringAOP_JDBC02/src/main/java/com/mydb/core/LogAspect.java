package com.mydb.core;

import org.aspectj.lang.JoinPoint;

public class LogAspect {

	//트랜잭션이 시작하는 부분
	public void before(JoinPoint jp) {
		System.out.println("[AOP] Before: " + jp.getSignature().getName());
	}

	//트랜잭션이 종류되는 부분 커밋된 이후의 작업 진행
	public void after(JoinPoint jp) {
		System.out.println("[AOP] After: " + jp.getSignature().getName());
	}
}
