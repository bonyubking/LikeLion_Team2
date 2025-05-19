package work04.com.test04;

import org.springframework.stereotype.Component;

@Component
public class Student {

  public void eat(String food) {
    System.out.println("[Student] "+food+" 먹는 중...");
  }

}
