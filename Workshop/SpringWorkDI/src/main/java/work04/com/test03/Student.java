package work04.com.test03;

import org.springframework.stereotype.Component;

@Component
public class Student {

  public void homework() {

    System.out.println("[Student] 과제 수행 중...");
    if (true) {
      throw new RuntimeException("숙제하다가 예외 발생!");
    }
  }
}
