package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext01.xml");
       // 구체클래스를 bean으로 등록하고 getBean()을 사용해서 선조 인터페이스로 리턴함
       Greet res = context.getBean("greeting",Greet.class);
       System.out.println(res.greeting());

       // 현재 메인영역에서 작업하는 context 확인
       System.out.println("== end main ==");
       System.out.println(context.toString());
       System.out.println(context.getDisplayName());

       // context 명시 소멸
//       if(context instanceof ConfigurableApplicationContext){
//         ((ConfigurableApplicationContext)context).close();
//       }

      // context close 됨을 확인
//       if(context instanceof ConfigurableApplicationContext){
//         boolean isActive = ((ConfigurableApplicationContext)context).isActive();
//         System.out.println(isActive);
//       }
    }
}
