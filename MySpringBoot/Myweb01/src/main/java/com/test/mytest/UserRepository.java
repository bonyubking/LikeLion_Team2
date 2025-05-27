package com.test.mytest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	// save, findbyid, findall, delete 등 CRUD  메소드 사용 가능
}
