package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static comm.JDBCTemplate.*; //자주 사용하는 정적메소드를 클래스명 없이 바로 참조해서 호출 

public class b_proc {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 번호 : ");
		int empno = sc.nextInt();
		
		//연결확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		
		try {
			String sql = "{call PRO02_DELETE(?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, empno);
			
			cstmt.executeUpdate(); // 
			System.out.println("삭제 후 커밋 진행");
			commit(conn);
		} catch (SQLException e) {
			System.out.println("오류가 발생하여 롤백 진행");
			rollback(conn);
			e.printStackTrace();
		} finally {
			Close(cstmt);
			Close(conn);
		}

	}

}
