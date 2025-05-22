package common;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Long empno;
    private String ename;
    private String job;
    private int mgr;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private int deptno;
}
