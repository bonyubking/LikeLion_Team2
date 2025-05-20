package com.mydb.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class EmpDao {

    private final JdbcTemplate jdbcTemplate;

    // 생성자 주입
    public EmpDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        System.out.println("EmpDao's constructor ");
    }

    // SELECT ALL
    public List<Emp> findAll() {
        String sql = "select * from emp";
        return jdbcTemplate.query(sql,new EmpRowMapper());
    }
  
    // 내부 RowMapper 클래스
    private static class EmpRowMapper implements RowMapper<Emp> {

        @Override
        public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Emp(
                rs.getInt("empno"),
                rs.getString("ename"),
                rs.getString("job"),
                rs.getInt("deptno"));
        }
    }

    public void insert(Emp emp){
        String sql = "insert into emp(empno, ename, job, deptno) values(?,?,?,?)";
        jdbcTemplate.update(sql,emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getDeptno());
    }
}
