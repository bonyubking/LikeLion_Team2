package com.lab05.controller;

import com.lab05.dto.EmpDeptDto;
import com.lab05.entity.Dept;
import com.lab05.entity.Emp;
import com.lab05.service.EmpDeptService;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class EmpDeptController {
  private final EmpDeptService empDeptService;

  @GetMapping("/emp-info")
  public String showEmpDeptInfo(Model model, // 2. 뷰 리졸버 값 전달 객체
      @RequestParam(defaultValue="0") int page, // 3. HTTP 요청 파라미터
      @RequestParam(defaultValue="5") int size,
      @RequestParam(defaultValue="ename") String sortBy,
      @RequestParam(defaultValue="asc") String direction){ // 4. HTTP 요청 파라미터
    Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
    Pageable pageable = PageRequest.of(page, size, sort);
    Page<EmpDeptDto> empPage = empDeptService.getEmpDeptPage(pageable);
    model.addAttribute("empPage", empPage);
    return "emp-info";
  }
  @GetMapping("/emps")
  public String showAllEmps(Model model){
    List<Emp> emps = empDeptService.getAllEmps();
    model.addAttribute("emps",emps);
    return "emps";

  }
  @GetMapping("/depts")
  public String showAllDepts(Model model){
    List<Dept> depts = empDeptService.getAllDepts();
    model.addAttribute("depts", depts);
    return "depts";

  }

}
