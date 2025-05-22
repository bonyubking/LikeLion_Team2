package com.test02;

import common.Emp;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmpServiceImpl implements EmpService {

  private static SqlSessionFactory factory;
  static {
    try {
      String resource = "config/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      factory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public List<Emp> selectAllEmp() {
    try(SqlSession session = factory.openSession()) {
      return session.getMapper(EmpMapper.class).selectAllEmp();
    }
  }

  @Override
  public Emp selectEmpByEmpno(Long empno) {
    try(SqlSession session = factory.openSession()) {
      return session.getMapper(EmpMapper.class).selectEmpByEmpno(empno);
    }
  }

  @Override
  public int insertEmp(Emp emp) {
    try(SqlSession session = factory.openSession()) {
      System.out.println("[INSERT 시도] 이름: "+emp.getEname());
      int res = session.getMapper(EmpMapper.class).insertEmp(emp);
      if(res > 0){
        session.commit();
        System.out.println("[COMMIT] 완료");
      }else{
        session.rollback();
      }
      return res;
    }
  }

  @Override
  public int insertEmpWithError(Emp emp) {
    try(SqlSession session = factory.openSession()) {
      System.out.println("[INSERT 시도] 이름: "+emp.getEname());
      int res = session.getMapper(EmpMapper.class).insertEmp(emp);
      if (res > 0) {
        System.out.println("[ROLLBACK 발생 시도]");
        session.rollback();
        throw new RuntimeException("[ROLLBACK 발생] 강제 예외 발생");
      } else {
        session.rollback();
        System.out.println("[ROLLBACK 발생] insert 실패");
      }
      return res;
    }
  }

  @Override
  public int updateEmp(Emp emp) {
    try(SqlSession session = factory.openSession()) {
      int res = session.getMapper(EmpMapper.class).updateEmp(emp);
      if(res > 0){
        session.commit();
      }else{
        session.rollback();
      }
      return res;
    }
  }

  @Override
  public int deleteEmp(Long empno) {
    try(SqlSession session = factory.openSession()) {
      int res = session.getMapper(EmpMapper.class).deleteEmp(empno);
      if(res > 0){
        session.commit();
      }else{
        session.rollback();
      }
      return res;
    }
  }
}
