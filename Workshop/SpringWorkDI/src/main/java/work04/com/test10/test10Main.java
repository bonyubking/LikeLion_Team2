package work04.com.test10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test10Main {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("work04/test10.xml");
    Student student = context.getBean("student", Student.class);
    student.anything();
  }
}
