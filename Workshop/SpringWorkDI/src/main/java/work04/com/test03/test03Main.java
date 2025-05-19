package work04.com.test03;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test03Main {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    Student student = context.getBean("student", Student.class);
    try {
      student.homework();
    } catch (Exception e) {

    }
  }
}
