package com.lab02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab02.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {
    //추가 코드 선언 _ 구체클래스로 구현 
	
}
