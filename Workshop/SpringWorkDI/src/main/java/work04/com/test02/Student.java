package work04.com.test02;

import org.springframework.stereotype.Component;

@Component
public class Student {

  public void getScore() {
    System.out.println("[Student] 점수 조회 중...");
  }
}
