package com.test02;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {
		
	@Override
	public Object invoke(MethodInvocation i) throws Throwable {
		
		System.out.println("method "+i.getMethod()+" is called on "+
		                        i.getThis()+" with args "+i.getArguments());
		
		
		Object ret= null;
		
		System.out.println("[AOP] 줌인 합니다 출석 확인");
		try {
			ret = i.proceed();
		} catch(Exception e) {
			System.out.println("[AOP] 학습중 오류발생");
		} finally {
			System.out.println("[AOP] 강의 종료후 퇴실 확인");
		}
		System.out.println("[AOP] 줌 로그아웃 ");
		
		
		System.out.println("method "+i.getMethod()+" returns "+ret);
		return ret;
		
	}
		 
		 
}
