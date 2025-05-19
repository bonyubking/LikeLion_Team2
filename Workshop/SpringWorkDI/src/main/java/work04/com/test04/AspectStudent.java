package work04.com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectStudent {

  @Before("execution(public void work04.com.test04.*.eat(..))")
  public void before(JoinPoint joinPoint) {
    System.out.println("[AOP] 먹을 준비 완료: "+joinPoint.getArgs()[0]);;
  }
}
