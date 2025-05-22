package com.test01;

import common.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMapperTest {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "config/applicationContext01.xml");

    Emp emp01 = context.getBean("emp01",Emp.class);
    Emp emp02 = context.getBean("emp02",Emp.class);

    EmpService empService = context.getBean(EmpService.class);
    empService.insertEmp(emp01);
    empService.insertEmp(emp02);

    System.out.println("사원 등록 완료!");
    System.out.println("사원 목록:");
    for(Emp emp : empService.selectAllEmp()){
      System.out.println(emp.getEname());
    }
  }
}
