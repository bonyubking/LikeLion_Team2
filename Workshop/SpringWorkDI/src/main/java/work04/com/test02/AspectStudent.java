package work04.com.test02;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectStudent {

  @AfterReturning("execution(public void work04.com.test02.*.getScore(..))")
  public void doAccessCheck() {
    System.out.println("[AOP] 점수 저장 완료");
  }
}
