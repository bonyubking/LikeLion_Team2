package com.sec01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    
	/*
	  <bean id="myaddress" class="com.sec01.MyAddress">
      <constructor-arg value="박길동" type="java.lang.String"/>
   </bean>
	*/
	@Bean
	public MyAddress myaddress() {
		return new MyAddress("강길동");
	}
	
	@Bean
	public MyAddress myaddress02() {
		return new MyAddress("박길동","제주도");
	}
	
	@Bean
	public MyAddress myaddress03() {
		return new MyAddress("강길동","인천","00-000-0000");
	}
	
	@Bean AddressInfo info() {
		AddressInfo info = new AddressInfo();
		info.setMyaddress(myaddress03()); // 의존성 주입
		info.setAge(100);
		return info;
	}
}
