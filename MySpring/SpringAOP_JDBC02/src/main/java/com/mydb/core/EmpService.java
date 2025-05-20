package com.mydb.core;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public class EmpService {

  @Autowired
  private final EmpDao empDao;

  public EmpService(EmpDao empDao) {
    this.empDao = empDao;
  }

  public List<Emp> getAll() {
    return empDao.findAll();
  }

  public void insertEmpwithFail(Emp emp) {
    empDao.insert(emp);
    if (true) {
      throw new RuntimeException("Force Exception!");
    }
  }

  public void insertEmpwithSuccess(Emp emp) {
    empDao.insert(emp);

  }
}
