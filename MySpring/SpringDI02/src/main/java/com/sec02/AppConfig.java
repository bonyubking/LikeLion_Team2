package com.sec02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(App.class)
public class AppConfig {

  @Bean({"AA","BB","CC"})
  public MessagePrinter messagePrinter01(HelloMessage helloMessage) {
    return new MessagePrinter(helloMessage);
  }

  @Bean
  public MessagePrinter messagePrinter02(MyMessage myMessage) {
    return new MessagePrinter(myMessage);
  }

  @Bean
  public Integer myResource02() {
    return 100;
  }
}
