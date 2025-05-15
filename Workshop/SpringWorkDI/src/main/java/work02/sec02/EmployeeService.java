package work02.sec02;

import java.util.List;
import java.util.Map;

public class EmployeeService {

  private Map<String, List<Employee>> departmentMap;

  public void setDepartmentMap(Map<String, List<Employee>> departmentMap) {
    this.departmentMap = departmentMap;
  }

  public void printAllEmployees() {
    for (String dept: departmentMap.keySet()) {
      System.out.printf("[%s 부서]\n", dept);
      for (Employee employee : departmentMap.get(dept)) {
        System.out.println(employee.toString());
      }
    }
  }
}
