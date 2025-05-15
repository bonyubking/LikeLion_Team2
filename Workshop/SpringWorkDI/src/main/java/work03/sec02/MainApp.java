package work03.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    int price = 10000;

    OrderService service = context.getBean("orderService", OrderService.class);
    System.out.println(service.order(1, price));
  }
}
