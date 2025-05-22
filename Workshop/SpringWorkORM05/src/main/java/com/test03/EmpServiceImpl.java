package com.test03;

import common.Emp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
public class EmpServiceImpl implements EmpService {

  private final EmpMapper empMapper;

  @Autowired
  public EmpServiceImpl(EmpMapper empMapper) {
    this.empMapper = empMapper;
  }

  @Override
  public List<Emp> selectAllEmp() {
    return empMapper.selectAllEmp();
  }

  @Override
  public Emp selectEmpByEmpno(Long empno) {
    return empMapper.selectEmpByEmpno(empno);
  }

  @Override
  @Transactional
  public int insertEmp(Emp emp) {
    return empMapper.insertEmp(emp);
  }

  @Override
  @Transactional
  public int insertThenFail(Emp emp) {
    int res = empMapper.insertEmp(emp);
    System.out.println("INSERT 성공 후 예외 발생 예정");
    throw new RuntimeException("강제 예외");

  }

  @Override
  @Transactional
  public int updateEmp(Emp emp) {
    return empMapper.updateEmp(emp);
  }

  @Override
  @Transactional
  public int deleteEmp(Long empno) {
    return empMapper.deleteEmp(empno);
  }
}
