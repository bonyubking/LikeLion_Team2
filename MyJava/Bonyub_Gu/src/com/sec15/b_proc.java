package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static common.JDBCTemplate.*;

public class b_proc {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 번호 : ");
		int empno = sc.nextInt();
		
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		
		try {
			
			String sql = "{ call PRO02_DELETE(?) }";
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, empno);
			
			cstmt.executeUpdate();
			System.out.println(" 삭제 했어 !!!");
			commit(conn);
			
			System.out.println(conn.isClosed());
			System.out.println("연결중.....");
			
		}	catch (SQLException e) {
				e.printStackTrace();
		}	finally {
				Close(conn);
		}
		
		
}}
	
