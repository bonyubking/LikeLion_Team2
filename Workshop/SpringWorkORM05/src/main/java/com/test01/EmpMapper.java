package com.test01;

import common.Emp;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmpMapper {

  @Results(id="allemp", value={
      @Result(property = "empno", column = "empno"),
      @Result(property = "ename", column = "ename"),
      @Result(property = "job", column = "job"),
      @Result(property = "mgr", column = "mgr"),
      @Result(property = "hiredate", column = "hiredate"),
      @Result(property = "sal", column = "sal"),
      @Result(property = "comm", column = "comm"),
      @Result(property = "deptno", column = "deptno")
  })
  @Select("SELECT * FROM EMP")
  List<Emp> selectAllEmp();

  @ResultMap("allemp")
  @Select("SELECT * FROM EMP WHERE EMPNO=#{empno}")
  Emp selectEmpByEmpno(Long empno);

  @Insert("INSERT INTO EMP(ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) "
      + "VALUES(#{ename},#{job},#{mgr},#{hiredate},#{sal},#{comm},#{deptno})")
  int insertEmp(Emp emp);

  @Update("UPDATE EMP "
      + "SET ENAME=#{ename}, JOB=#{job}, MGR=#{mgr}, "
      + "HIREDATE=#{hiredate}, SAL=#{sal}, COMM=#{comm}, DEPTNO=#{deptno}")
  int updateEmp(Emp emp);

  @Delete("DELETE FROM EMP WHERE EMPNO=#{empno}")
  int deleteEmp(Long empno);
}
