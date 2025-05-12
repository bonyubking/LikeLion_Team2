package com.sec14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class e_insertPrepared {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//연결
		try {
			
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_emp?" + "user=root&password=kus951024*");

		    if (!conn.isClosed()) {
		    	System.out.println("연결 중이야");
		    }
		    //명령 수행
		    conn.setAutoCommit(false);
		    int empno = 2;
		    String ename = "박길동";
		    double sal = 5500;
		    
		    String sql_insert = "insert into emp(empno, ename, sal) values (?, ?, ?)";
		    pstmt = conn.prepareStatement(sql_insert);
		    
		    //sql_insert 매개변수에 값 전달 및 변경 코드
		    pstmt.setInt(1, empno);
		    pstmt.setString(2, ename);
		    pstmt.setDouble(3, sal);
		    
		    int res  = pstmt.executeUpdate();
		    if (res > 0) {
		    	conn.commit();
		    }else {
		    	System.out.println("쿼리 오류");
		    	conn.rollback();
		    }
		    
		    //2-2 select
		    String sql = "select * from emp;";
		    rs = pstmt.executeQuery(sql);
		    
		    // 결과 출력
		    while(rs.next()) {
		    	System.out.println(rs.getString("empno") + "\t" + rs.getString("ename") + "\t" + rs.getString("sal"));
		    }
		    
		} catch (SQLException ex) {
		   
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}