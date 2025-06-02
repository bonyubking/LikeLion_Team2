package com.lab05.service;

import com.lab05.dto.EmpDeptDto;
import com.lab05.entity.Dept;
import com.lab05.entity.Emp;
import com.lab05.repository.DeptRepository;
import com.lab05.repository.EmpDeptRepository;
import com.lab05.repository.EmpRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpDeptService {

  private final EmpDeptRepository empDeptRepository;
  private final EmpRepository empRepository;
  private final DeptRepository deptRepository;

  public List<EmpDeptDto> getEmpDeptDtos(){
    return empDeptRepository.findEmpDeptInfo();
  }
  public List<Emp> getAllEmps(){
    return empRepository.findAll();
  }
  public List<Dept> getAllDepts(){
    return deptRepository.findAll();
  }
  public Page<EmpDeptDto> getEmpDeptPage(Pageable pageable){
    return empDeptRepository.findEmpDeptPage(pageable);
  }
}
