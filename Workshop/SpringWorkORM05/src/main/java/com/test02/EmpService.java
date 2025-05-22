package com.test02;

import common.Emp;
import java.util.List;

public interface EmpService {
  List<Emp> selectAllEmp();
  Emp selectEmpByEmpno(Long empno);
  int insertEmp(Emp emp);
  int insertEmpWithError(Emp emp);
  int updateEmp(Emp emp);
  int deleteEmp(Long empno);
}
