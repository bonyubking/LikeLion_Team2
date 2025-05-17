package com.person.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate; //common/JDBCTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource; //DB연결속성정보를 가진 객체

import javax.sql.*;

@Configuration
@ComponentScan(basePackages = "com.person")
@PropertySource("classpath:db.properties")
public class AppConfig {

  @Bean
  public DataSource dataSource(Environment env) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("driver"));
    dataSource.setUrl(env.getProperty("url"));
    dataSource.setUsername(env.getProperty("username"));
    dataSource.setPassword(env.getProperty("password"));

    return dataSource;
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
}
