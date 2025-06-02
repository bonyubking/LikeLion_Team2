package com.lab05.repository;

import com.lab05.dto.EmpDeptDto;
import com.lab05.entity.Emp;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpDeptRepository extends JpaRepository<Emp,Integer> {

  @Query("SELECT new com.lab05.dto.EmpDeptDto(e.ename, e.sal, d.dname)"
      + " FROM Emp e JOIN e.dept d")
  List<EmpDeptDto> findEmpDeptInfo();

  @Query(value = "SELECT e.ename, e.sal, d.dname FROM Emp e JOIN Dept d ON e.deptno = d.deptno", nativeQuery=true)
  List<Object[]> findEmpDeptNative();

  @Query("SELECT new com.lab05.dto.EmpDeptDto(e.ename, e.sal, d.dname) " + "FROM Emp e JOIN e.dept d")
  Page<EmpDeptDto> findEmpDeptPage(Pageable pageable); // Page = 데이터 정보(emp) + 페이지 정보

  /*
  * select e.ename, e.sal, d.dname
  * from emp e
  * join dept d on e.deptno=d.deptno
  * limit ?, ? -> offset, pageSize 기반으로 결정됨
  * */
  // case 4:  nativeQuery를 사용한 카운트 처리 -> 명시적으로 전체 개수 처리를 지정해줘야함
  @Query(value = "SELECT e.ENAME, e.SAL, d.DNAME " +
      "FROM EMP e NATURAL JOIN DEPT d",
      countQuery = "SELECT COUNT(*) FROM EMP e NATURAL JOIN DEPT d", //전체 페이지 개수 계산용
      nativeQuery = true)
  Page<Object[]> findEmpDeptPageNative(Pageable pageable);
}
