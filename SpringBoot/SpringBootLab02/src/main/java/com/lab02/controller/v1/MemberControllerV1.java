package com.lab02.controller.v1;

import com.lab02.entity.Member;
import com.lab02.service.MemberService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberControllerV1 {

  private final MemberService memberService;

  @RequestMapping
  public ResponseEntity<List<Member>> getAllMembers(){
    return ResponseEntity.ok(memberService.getAllMembers());
  }

  @RequestMapping("/{id}")
  public ResponseEntity<Member> getMemberById(@PathVariable Long id){
    return ResponseEntity.ok(memberService.getMemberById(id));
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Member> createMember(@Valid @RequestBody Member member){
    return ResponseEntity.status(HttpStatus.CREATED).body(memberService.saveMember(member));
  }

  @RequestMapping(path="/{id}", method=RequestMethod.PUT)
  public ResponseEntity<Member> updateMember(@PathVariable Long id, @Valid @RequestBody Member member){
    return ResponseEntity.ok(memberService.saveMember(member));
  }

  @RequestMapping(path="/{id}", method=RequestMethod.DELETE)
  public void deleteMember(@PathVariable Long id){
    memberService.deleteMember(id);
  }
}
