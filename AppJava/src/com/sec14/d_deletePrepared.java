package com.sec14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class d_deletePrepared {
	public static void main(String[] args) {
		
		//1. 연결 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "";
			String user = "";
			String password="";
		    conn = DriverManager.getConnection(url,user,password);

		    if(!conn.isClosed()) {
		    	System.out.println("연결 중");
		    }

		//2. 명령 수행	 : 사원번호, 이름, 봉급을 매개변수 이용해서 코드 구현

		    // 2-1. INSERT
		    conn.setAutoCommit(false);
		    String ename = "홍길동";
		    
		    String sql_delete = "DELETE FROM EMP WHERE ENAME = ?";
		    pstmt = conn.prepareStatement(sql_delete);
		    
		    // sql_insert 매개변수에 값전달 및 변경 코드 
		    pstmt.setString(1,ename);

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
