package work04.com.test08;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectStudent {

  @Around("execution(public void work04.com.test08.Student.*(..))")
  public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("[AOP] 수업 준비");
    Object result = joinPoint.proceed();
    System.out.println("[AOP] 수업 종료");
    return result;
  }
}
