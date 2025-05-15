package work03.sec03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class MainApp {

  public static void main(String[] args) {
    ApplicationContext context = new GenericGroovyApplicationContext
        ("work03/application.groovy");
    int price = 10000;

    OrderService service = context.getBean("orderService", OrderService.class);
    System.out.println(service.order(1, price));
  }

}
