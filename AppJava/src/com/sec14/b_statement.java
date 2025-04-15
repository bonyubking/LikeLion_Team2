package com.sec14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class b_statement {
	public static void main(String[] args) {
		
		//1. 연결 
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String url = "";
			String user = "";
			String password="";
		    conn = DriverManager.getConnection(url,user,password);

		    if(!conn.isClosed()) {
		    	System.out.println("연결 중");
		    }

		//2. 명령 수행	
		    stmt = conn.createStatement();
		    String sql = "select * from emp";
		    rs = stmt.executeQuery(sql);
		    
		//3. 결과 출력	
		    while(rs.next()) {
//		    	System.out.println(rs.getString(1)+"\t"+rs.getString(2));
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
