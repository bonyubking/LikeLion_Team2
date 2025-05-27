package com.lab02.service;

import com.lab02.entity.Member;
import com.lab02.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public List<Member> getAllMembers(){
    return memberRepository.findAll();
  }
  public Member getMemberById(Long id){
    return memberRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Member not found"));
  }
  public Member saveMember(Member member){
    return memberRepository.save(member);
  }
  public Member updateMember(Long id, Member member){
    return memberRepository.save(member);
  }
  public void deleteMember(Long id){
    memberRepository.deleteById(id);
  }
}
