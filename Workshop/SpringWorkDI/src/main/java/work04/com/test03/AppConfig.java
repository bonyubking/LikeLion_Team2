package work04.com.test03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "work04.com.test03")
@EnableAspectJAutoProxy // AOP 어노테이션 활성화 <aop:aspectj-autoproxy/>
public class AppConfig {

}
