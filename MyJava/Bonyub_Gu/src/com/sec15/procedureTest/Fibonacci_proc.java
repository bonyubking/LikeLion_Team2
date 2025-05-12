package com.sec15.procedureTest;

import static common.JDBCTemplate.Close;
import static common.JDBCTemplate.getConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Fibonacci_proc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("피보나치  : ");
		int p_limit = sc.nextInt();
		
		
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "{ call 04_FIBONACCI(?) }";
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, p_limit);
			
			rs = cstmt.executeQuery();
			
			while(rs.next()) {
				int n = rs.getInt("항 번호");
				int fib = rs.getInt("피보나치 수열값");
				
				System.out.printf("%5d %5d\n", n, fib);
			}
			
			System.out.println(conn.isClosed());
			System.out.println("연결중.....");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(rs);
			Close(cstmt);
			Close(conn);
			sc.close();
		}
	}

}
