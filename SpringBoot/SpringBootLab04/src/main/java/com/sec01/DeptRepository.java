package com.sec01;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept,Integer> {
  List<Dept> findByDname(String dname);
  List<Dept> findByDnameContaining(String keyword);
}
