package work05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import work05.config.AppConfig;
import work05.domain.Member;
import work05.service.MemberService;

public class App {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = context.getBean(MemberService.class);
    Member member = new Member(1L,"홍길동","aaa@aaa.com");
    memberService.register(member);
  }
}
