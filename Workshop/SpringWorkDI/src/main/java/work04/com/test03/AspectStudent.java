package work04.com.test03;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectStudent {

  @AfterThrowing(pointcut = "execution(public void work04.com.test03.*.homework(..))", throwing = "e")
  public void throwing() {
    System.out.println("[AOP] 과제 오류 발생: 파일 오류");
  }
}
