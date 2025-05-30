package com.sec01;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class EmpService {

  private final EmpRepository empRepository;

  // 사원 전체 조회
  public List<Emp> findAll() {
    return empRepository.findAll();
  }

  // 사원 상세 조회
  public Emp findById(int empno) {
    return empRepository.findById(empno).orElse(null);
  }

  // 사원 등록 및 수정
  @Transactional
  public void save(Emp emp){
    empRepository.save(emp);
  }
  
  // 사원 삭제
  @Transactional
  public void delete(int empno){
    empRepository.deleteById(empno);
  }
}
