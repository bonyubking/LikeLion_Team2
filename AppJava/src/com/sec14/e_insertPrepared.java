package com.sec14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class e_insertPrepared {
	public static void main(String[] args) {
		
		//1. 연결 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:mysql://localhost:3306/my_emp";
			String user = "mydb";
			String password="chlwlgns9754@";
//		    conn =
//		       DriverManager.getConnection("jdbc:mysql://localhost:3306/my_emp?" +
//		                                   "user=mydb&password=chlwlgns9754@");
		    conn = DriverManager.getConnection(url,user,password);

		    if(!conn.isClosed()) {
		    	System.out.println("연결 중");
		    }

		//2. 명령 수행	 : 사원번호, 이름, 봉급을 매개변수 이용해서 코드 구현

		    // 2-1. INSERT
		    conn.setAutoCommit(false);
		    int empno = 1;
		    String ename = "홍길동";
		    double sal = 5500; 
		    
		    String sql_insert = "INSERT INTO EMP(EMPNO,ENAME,SAL) VALUES(?,?,?)";
		    pstmt = conn.prepareStatement(sql_insert); // 구문 준
		    
		    // sql_insert 매개변수에 값전달 및 변경 코드 
		    pstmt.setInt(1,empno); //매개변수 바인딩
		    pstmt.setString(2,ename);
		    pstmt.setDouble(3, sal);
		    
		    
		    int res = pstmt.executeUpdate();
		    
		    if(res>0) {
		    	conn.commit();
		    }else {
		    	System.out.println("롤백");
		    	conn.rollback();
		    }
		    
		    
		    // 2-3. SELECT
		    String sql = "SELECT * FROM EMP";
		    rs=pstmt.executeQuery(sql);
		    
		    
		    
		//3. 결과 출력	
		    while(rs.next()) {
		    	System.out.println(rs.getString("empno")+"\t"+rs.getString("ename")+"\t"+rs.getDouble(6));
		    }
		    
		    
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
