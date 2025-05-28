package com.test01.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test01.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> { 
	//추가 메소드 
	// Optional : 리턴값이 null, null x -> NullPointException (NPE) 방지 
    Optional<Member> findByUsername(String username); 
    
    // 전체 회원 중 ID 내림차순 5명 조회
    List<Member> findTop5ByOrderByIdDesc();

}
