package com.test01.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BeanLister {

  @Bean
  public CommandLineRunner listBeans(ApplicationContext ctx) {
    return args -> {
      System.out.println("🔍 등록된 Bean 목록:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames); // 알파벳순 정렬

      for (String beanName : beanNames) {
        System.out.println(" - " + beanName);
      }
    };
  }
}