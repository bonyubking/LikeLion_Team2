package work04.com.test05;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "work04.com.test05")
@EnableAspectJAutoProxy
public class AppConfig {

}
