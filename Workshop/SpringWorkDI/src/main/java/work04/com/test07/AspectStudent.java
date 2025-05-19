package work04.com.test07;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectStudent {

  @Before("execution(public void work04.com.test07.Student.*Work(..))")
  public void before() {
    System.out.println("[AOP] 작업 시작");;
  }
}
