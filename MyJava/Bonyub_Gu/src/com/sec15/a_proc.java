package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static common.JDBCTemplate.*;

public class a_proc {
	public static void main(String[] args) {
		
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		
		try {
			
			String sql = "{ call my_emp.PRO01_INSERT() }";
			cstmt = conn.prepareCall(sql);
			
			cstmt.execute();
			commit(conn);

			
		}	catch (SQLException e) {
				rollback(conn);
				e.printStackTrace();
		}	finally {
				Close(conn);
				Close(cstmt);
		}
		
		
}}
	
