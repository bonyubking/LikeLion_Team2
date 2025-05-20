package work04.com.test02;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectStudent {

  @AfterReturning(pointcut = "execution(* work04.com.test02.*.getScore(..))", returning="retVal")
  public void doAccessCheck(Object retVal) {
    System.out.println("[AOP] 점수 저장 완료 : "+retVal);
  }
}
