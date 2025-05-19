package com.sec02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(App.class)
public class AppConfig {
	
	@Bean({"abctest","bb","cc"})
	public MessagePrinter messagePrint(HelloMessage helloMessage) {
		
		return new MessagePrinter(helloMessage);
	}
	
	@Bean
	public MessagePrinter messagePrint02(MyMessage myMessage) {
		return new MessagePrinter(myMessage);
	}
	
	@Bean
	public Integer myResource02() {
		return 100;
	}
	
}
