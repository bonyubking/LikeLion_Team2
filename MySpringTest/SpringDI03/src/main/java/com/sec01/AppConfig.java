package com.sec01;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AppConfig {
	/*
	<bean id="myaddress" class="com.sec01.MyAddress">
	<constructor-arg value = "gogogo"/>  
	</bean>
	*/
	
	@Bean
	public MyAddress myaddress() {
		return new MyAddress("박길동");
	}
	
	@Bean
	public MyAddress myaddress02() {
		return new MyAddress("박길동", "제주");
	}
	
	@Bean
	public MyAddress myaddress03() {
		return new MyAddress("본엽", "부산", "123");
	}
	
	@Bean AddressInfo info() {
		AddressInfo info = new AddressInfo();
		info.setAddress(myaddress03());
		info.setNum(100);
		return info;
	}
	
}
