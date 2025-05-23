package com.test.myweb01;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  // save, findById, findAll, delete 등 기본 CRUD는 구현되어 있음



}
