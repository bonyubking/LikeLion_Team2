package work04.com.test08;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "work04.com.test08")
@EnableAspectJAutoProxy
public class AppConfig {

}
