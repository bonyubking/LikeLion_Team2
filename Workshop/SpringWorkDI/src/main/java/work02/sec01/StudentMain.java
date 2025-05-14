package work02.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import work02.sec02.EmployeeService;

public class StudentMain {

  public static void main(String[] args) {
    ApplicationContext ctx = new
        ClassPathXmlApplicationContext("applicationContext02.xml");
    EmployeeService service = ctx.getBean("employeeService",
        EmployeeService.class);
    service.printAllEmployees();
  }

}
