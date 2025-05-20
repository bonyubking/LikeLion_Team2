package com.mydb.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpAppMain {

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc02.xml");
    EmpService service = ctx.getBean(EmpService.class);
    service.getAll().forEach(System.out::println);

    try {
      Emp newEmp = new Emp(8000, "HeeYeon Kim", "SALESMAN", 10);
      service.insertEmpwithFail(newEmp);
    } catch (Exception e) {
      System.out.println("exception: " + e.getMessage());
    }

    System.out.println("============");
    service.getAll().forEach(System.out::println);

    try {
      Emp newEmp = new Emp(8001, "Sample", "Director", 10);
      service.insertEmpwithSuccess(newEmp);
    } catch (Exception e) {
      System.out.println("exception: " + e.getMessage());
    }

    System.out.println("============");
    service.getAll().forEach(System.out::println);
  }
}