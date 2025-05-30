package com.sec01;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeptService {

  private final DeptRepository deptRepository;

  //부서 전체 조회
  public List<Dept> findAll() {
    return deptRepository.findAll();
  }

  //부서 상세 조회
  public Dept findById(int deptno) {
    return deptRepository.findById(deptno).orElse(null);
  }
}
