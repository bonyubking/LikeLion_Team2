package com.test02;

public class MemoryMemberRepository implements MemberRepository {

	@Override
	public String findMemberById(int Id) {

        return "홍길동";
	}

}
