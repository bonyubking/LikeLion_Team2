package work04.com.test06;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectStudent {

  @AfterReturning(pointcut = "execution(public int work04.com.test06.Student.calculate(..))", returning = "num")
  public void doAccessCheck(int num) {
    System.out.println("[AOP] 정수 반환 완료 : " + num);;
  }
}
