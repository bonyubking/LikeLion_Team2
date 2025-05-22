package work05.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "work05")
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class AppConfig {

  @Autowired
  private Environment env;

  @Bean
  public DataSource dataSource(){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("driver"));
    dataSource.setUrl(env.getProperty("url"));
    dataSource.setUsername(env.getProperty("username"));
    dataSource.setPassword(env.getProperty("password"));
    return dataSource;
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource ds) {
    return new JdbcTemplate(ds);
  }

  @Bean
  @Primary
  public DataSourceTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean
  public DataSourceTransactionManager auditTxManager(DataSource dataSource){
    return new DataSourceTransactionManager(dataSource);
  }

}
