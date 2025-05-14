package work02.sec01;

import java.util.List;
import java.util.OptionalDouble;

public class StudentService {
  private List<Student> studentList;

  public void setStudentList(List<Student> studentList) {
    this.studentList = studentList;
  }

  public void printAllInfo(){
    for (Student student : studentList) {
      System.out.println(student.studentInfo());
    }
    System.out.println();
  }
  public void printStats(){
    double avgAge = studentList.stream().mapToInt(Student::getAge).average().orElse(0);
    double avgHeight = studentList.stream().mapToInt(Student::getHeight).average().orElse(0);
    double avgWeight = studentList.stream().mapToInt(Student::getWeight).average().orElse(0);

    System.out.printf("평균 나이: %.3f\n",avgAge);
    System.out.printf("평균 신장: %.3f\n",avgHeight);
    System.out.printf("평균 몸무게: %.3f\n",avgWeight);
  }

}
