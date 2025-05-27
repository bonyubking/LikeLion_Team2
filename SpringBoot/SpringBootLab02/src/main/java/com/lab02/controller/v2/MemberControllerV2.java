package com.lab02.controller.v2;

import com.lab02.dto.MemberDto;
import com.lab02.service.MemberService;
import com.lab02.entity.Member;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/members")
@RequiredArgsConstructor
public class MemberControllerV2 {
  private final MemberService memberService;

  @GetMapping
  public ResponseEntity<List<MemberDto>> getAllMembers(){
    List<Member> members = memberService.getAllMembers();
    return ResponseEntity
              .status(HttpStatus.OK)
              .body(members
                    .stream()
                    .map(member -> new MemberDto(member.getId(),member.getName()))
                    .collect(Collectors.toList()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<MemberDto> getMemberById(@PathVariable Long id){
    Member member = memberService.getMemberById(id);
    return ResponseEntity.status(HttpStatus.OK).body(new MemberDto(member.getId(),member.getName()));
  }

  @PostMapping
  public ResponseEntity<MemberDto> createMember(@Valid @RequestBody Member member){
    Member newMember = memberService.saveMember(member);
    return ResponseEntity.status(HttpStatus.CREATED).body(new MemberDto(newMember.getId(),newMember.getName()));
  }

  @PutMapping("/{id}")
  public ResponseEntity<MemberDto> updateMember(@PathVariable Long id, @Valid @RequestBody Member member){
    Member updateMember = memberService.saveMember(member);
    return ResponseEntity.ok(new MemberDto(updateMember.getId(),updateMember.getName()));
  }

  @DeleteMapping("/{id}")
  public void deleteMember(@PathVariable Long id){
    memberService.deleteMember(id);
  }
}
