package com.sec01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  /*
  * <bean id="myAddress" class="com.sec01.MyAddress">
  *     <constructor-arg value="홍길동" />
  * </bean>
  * */

  @Bean
  public MyAddress myAddress(){
    return new MyAddress("박길동");
  }

  @Bean
  public MyAddress myAddress02(){
    return new MyAddress("정길동","제주도");
  }

  @Bean
  public MyAddress myAddress03(){
    return new MyAddress("최길동","부산","051-000-0000");
  }

  @Bean
  public AddressInfo info(){
    AddressInfo info = new AddressInfo();
    info.setMyAddress( myAddress03()); //의존성 주입
    info.setAge(100);
    return info;
  }
}
