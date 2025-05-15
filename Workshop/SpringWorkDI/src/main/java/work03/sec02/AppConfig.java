package work03.sec02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  @Bean
  public DiscountPolicy discountPolicy() {
    return new RateDiscountPolicy();
  }

  @Bean
  public OrderService orderService(MemberRepository memberRepository,
      DiscountPolicy discountPolicy) {

    return new OrderServiceImpl(memberRepository, discountPolicy);
  }
}
