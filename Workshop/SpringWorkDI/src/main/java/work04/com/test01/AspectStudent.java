package work04.com.test01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectStudent {

  @Before("execution(public void work04.com.test01.Student.study(..))")
  public void before(JoinPoint joinPoint) {
    System.out.println("[AOP] 공부 시작합니다.");
  }
}
