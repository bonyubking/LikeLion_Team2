package work05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work05.domain.Member;
import work05.repository.MemberRepository;

@Service
public class MemberService {

  private final MemberRepository repo;
  private final MailService mailService;

  @Autowired
  public MemberService(MemberRepository repo, MailService mailService){
    this.repo = repo;
    this.mailService = mailService;
  }

  @Transactional
  public void register(Member member){
    repo.save(member);
    mailService.sendWelcomeMail(member);
  }
}
