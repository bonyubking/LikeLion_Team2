package com.mydb.core;


import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmpService {
    private final EmpDao empDao;

  
    public EmpService(EmpDao empDao) {
        this.empDao = empDao;
    }

    public List<Emp> getAll() {
        return empDao.findAll();
    }
}
