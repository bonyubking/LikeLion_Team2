package work05.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0) // 트랜잭션보다 먼저 실행
public class LoggingAspect {

  @Before("execution(* work05..*(..))")
  public void logStart() {
    System.out.println("메서드 시작 로그");
  }
}
