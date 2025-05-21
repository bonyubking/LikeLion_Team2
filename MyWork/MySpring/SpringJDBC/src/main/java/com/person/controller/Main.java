package com.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.person.config.*;

@Configuration
@ComponentScan(basePackages="com.person")
@PropertySource("classpath:db.properties")
public class Main {
	public static void main(String[] args) {
	ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
	
	PersonController controller = ctx.getBean(PersonController.class);
	
	controller.run();
	
	((AbstractApplicationContext)ctx).close();

	}
}
