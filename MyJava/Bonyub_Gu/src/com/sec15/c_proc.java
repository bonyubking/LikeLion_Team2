package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static common.JDBCTemplate.*;

public class c_proc {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("변경할 번호  : ");
		int empno = sc.nextInt();
		Scanner sc2 = new Scanner(System.in);
		System.out.println("변경할 이름  : ");
		String ename = sc2.nextLine();
		
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		
		try {
			
			String sql = "{ call PRO03_UPDATE(?, ?) }";
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, empno);
			cstmt.setString(2, ename);
			
			cstmt.executeUpdate();
			System.out.println(" 변경 했어 !!!");
			commit(conn);
			
			System.out.println(conn.isClosed());
			System.out.println("연결중.....");
			
		}	catch (SQLException e) {
				e.printStackTrace();
		}	finally {
				Close(conn);
		}
		
		
}}
	
