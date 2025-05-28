package com.test01.service;

import com.test01.entity.Member;
import com.test01.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public Member register(Member member) {
    // 암호화된 패스워드를 가진 멤버를 insert 하게 됨
    member.setPassword(passwordEncoder.encode(member.getPassword()));
    System.out.println("비밀번호: "+member.getPassword());
    return memberRepository.save(member);
  }

  public List<Member> getAllMembers() {
    return memberRepository.findTop5ByOrderByIdDesc();
  }
}
