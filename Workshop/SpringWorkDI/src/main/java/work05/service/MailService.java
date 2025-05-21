package work05.service;

import org.springframework.stereotype.Service;
import work05.domain.Member;

@Service
public class MailService {
  public void sendWelcomeMail(Member member){
    System.out.println(member.getName()+"님 메일 전송");
  }

}
