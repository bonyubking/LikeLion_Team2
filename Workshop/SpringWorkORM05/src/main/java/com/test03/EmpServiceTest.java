package com.test03;

import common.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpServiceTest {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "config/applicationContext03.xml");

    Emp emp01 = context.getBean("emp01",Emp.class);
    Emp emp02 = context.getBean("emp02",Emp.class);

    EmpService empService = context.getBean(EmpService.class);

    empService.insertEmp(emp01);
    empService.insertThenFail(emp02);
  }
}
