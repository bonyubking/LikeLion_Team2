package work04.com.test07;

import org.springframework.stereotype.Component;

@Component
public class Student {

  public void homeWork() {
    System.out.println("[Student] 숙제 중...");
  }

  public void relax(){
    System.out.println("[Student] AOP X");
  }
}
