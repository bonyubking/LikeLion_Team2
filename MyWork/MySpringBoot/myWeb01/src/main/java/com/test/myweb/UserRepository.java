package com.test.myweb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
	//save(),findById(),findAll(),delete() 등 = CRUD 

}
