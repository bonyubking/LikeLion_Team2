package com.Person.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.*;


@Configuration
@ComponentScan(basePackages = "com.person")
@PropertySource("classpath:db.properties")
public class AppConfig {
	
	@Bean
	public DataSource dataSource(org.springframework.core.env.Environment env) {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		ds.setDriverClassName(env.getProperty("driver"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("user"));
		ds.setPassword(env.getProperty("password"));
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate (DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
