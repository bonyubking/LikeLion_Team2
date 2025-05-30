package com.sec01;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmpController {

  private final EmpService empService;
  private final DeptService deptService;

  @GetMapping
  public String redirectToList() {
    return "redirect:/emp/list";
  }

  // 사원 목록 및 부서 목록 조회
  @GetMapping("/list")
  public String getEmpList(Model model){
    List<Emp> emps = empService.findAll();
    List<Dept> depts = deptService.findAll();

    model.addAttribute("emps", emps);
    model.addAttribute("depts", depts);
    return "emp/list";
  }

  // 사원 등록 화면 표시
  @GetMapping("/new")
  public String newEmp(Model model) {
    model.addAttribute("emp", new Emp()); //폼 입력값을 채우고 제출할 땐 빈 Emp()객체 전달
    model.addAttribute("depts",deptService.findAll());
    return "emp/new";
  }

  // 사원 등록 처리
  /*
  * POST /emp
  *   @GetMapping("/new") -> 요청되면 빈Emp 객체를 가지고 emp/new.html 이동한 후 데이터 채운
  *   emp 객체를 가지고 현재 메소드가 호출됨
  * */
  @PostMapping
  public String save(Emp emp) {
    empService.save(emp);
    return "redirect:/emp";
  }

  // 사원 상세 정보 조회
  /*
  * /emp/{empno} <a th:href="@{'/emp/'+${emp.empno}}" class="btn btn-info btn-sm">상세</a>
  * */
  @GetMapping("/{empno}")
  public String getEmp(@PathVariable int empno, Model model) {
    Emp emp = empService.findById(empno);
    model.addAttribute("emp", emp);
    return "emp/detail";
  }

  //사원 수정 화면 표시
  @GetMapping("/{empno}/edit")
  public String editForm(@PathVariable int empno, Model model) {
    Emp emp = empService.findById(empno);
    List<Dept> depts = deptService.findAll();
    model.addAttribute("emp", emp);
    model.addAttribute("depts",depts);
    return "emp/edit";
  }

  // 사원 수정 처리
  @PostMapping("/{empno}/edit")
  public String updateEmp(@PathVariable int empno,@ModelAttribute Emp empDetails) {
    Emp emp = empService.findById(empno);
    if(emp!=null){
      emp.setEname(empDetails.getEname());
      emp.setJob(empDetails.getJob());
      emp.setSal(empDetails.getSal());
      emp.setDept(empDetails.getDept());
      empService.save(emp);
    }
    return "redirect:/emp/list";
  }

  // 사원 삭제 처리
  @PostMapping("/{empno}/delete")
  public String deleteEmp(@PathVariable int empno) {
    empService.delete(empno);
    return "redirect:/emp/list";
  }
}
