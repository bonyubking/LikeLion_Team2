package work04.com.test05;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectStudent {

  @Pointcut("execution(public void work04.com.test05.Student.*(..))")
  public void allMethod() {
  }

  @Before("allMethod()")
  public void before() {
    System.out.println("[AOP] 학생용 AOP 적용");;
  }

}
