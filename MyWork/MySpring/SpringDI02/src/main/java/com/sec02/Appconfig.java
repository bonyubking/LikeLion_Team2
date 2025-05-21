package com.sec02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

@Configuration
@Import(App.class)
public class Appconfig {
		  @Bean(name={"AA","BB","DD"})
		  @Lazy
		public MessagePrinter messagePrint(HelloMessage hellomessage) {
			return new MessagePrinter(hellomessage);
		}
		
		@Bean
		public MessagePrinter messagePrint02(MyMessage mymessage) {
			return new MessagePrinter(mymessage);
		}
		
		@Bean
		public Integer myResource02() {
			return 100;
		}

	}

