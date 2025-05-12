package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static common.JDBCTemplate.*;

public class d_proc {
	public static void main(String[] args) {
		
		
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;

		
		
		try {
			
			String sql = "{ call PRO06_SELECTALL() }";
			cstmt = conn.prepareCall(sql);
			
			rs = cstmt.executeQuery();
			
			///출력
			while(rs.next()) {
				
				int empno = rs.getInt("empno");
				String name = rs.getString("ename");
				int deptno = rs.getInt("deptno");
				
				System.out.printf(" %5d %10s %5d\n", empno, name, deptno);
			}
			
			System.out.println(conn.isClosed());
			System.out.println("연결중.....");
			
		}	catch (SQLException e) {
				e.printStackTrace();
		}	finally {
				
				Close(rs);
				Close(cstmt);
				Close(conn);
		}
		
		
}}
	
