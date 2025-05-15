package com.sec03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {

  public static void main(String[] args) {
    /*
    * singleton(기본) : 같은 id bean을 여러번 호출 -> 생성과 소멸 관리
    * prototype : 하나의 id를 여러개의 getBean()을 이용한 객체로 생성함
    * -> 요청할때마다 새로 생성
    * -> 생성만 관리
    * */

    ApplicationContext context =
        new ClassPathXmlApplicationContext("applicationContext03.xml");

    GreetService greetService01 = context.getBean("greeting", GreetService.class);
    GreetService greetService02 = context.getBean("greeting", GreetService.class);
    //greetService01.sayHello();

    // 1. 객체 참조가 동일한지 확인
    System.out.println(greetService01);
    System.out.println(greetService02);

    // 2. 주소로 확인
    System.out.println(greetService01 == greetService02);

    // 3. 해시코드로 확인
    System.out.println(System.identityHashCode(greetService02));

  }
}
