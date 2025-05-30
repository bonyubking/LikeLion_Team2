package com.sec01;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Emp,Integer> {
  //findBy Dept Deptno
  // JPQL -> select e from emp e where e.dept.deptno = :deptno
  List<Emp> findByDept_Deptno(int deptno);
  List<Emp> findByEname(String name);
  List<Emp> findByEnameContaining(String keyword);
  List<Emp> findBySalGreaterThanEqual(int sal);
}
