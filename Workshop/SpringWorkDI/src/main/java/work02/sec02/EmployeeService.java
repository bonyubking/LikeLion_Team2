package work02.sec02;

import java.util.List;
import java.util.Map;

public class EmployeeService {

  private Map<String, List<Employee>> departmentMap;

  public void setDepartmentMap(Map<String, List<Employee>> departmentMap) {
    this.departmentMap = departmentMap;
  }

  public void printAllEmployees(){
    for(Map.Entry<String, List<Employee>> entry : departmentMap.entrySet()){
      System.out.printf("[%s 부서]\n", entry.getKey());
      for(Employee employee : departmentMap.get(entry.getKey())){
        System.out.println(employee.toString());
      }
    }
  }
}
