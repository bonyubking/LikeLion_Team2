package com.lab05.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dept {
  @Id
  private int deptno;
  private String dname;
  private String loc;
  @OneToMany(mappedBy = "dept")
  private List<Emp> emps;
}
