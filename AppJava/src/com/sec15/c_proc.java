package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static comm.JDBCTemplate.*; //자주 사용하는 정적메소드를 클래스명 없이 바로 참조해서 호출 

// 사원번호와 이름을 입력받아 수정 3번의 이름을 홍길동으로 변경 
public class c_proc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 사원의 사원번호와 이름 : ");
		int empno = sc.nextInt();
		String ename = sc.next();
		
		//연결확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		try {
			String sql = "{call PRO03_UPDATE(?,?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1,empno);
			cstmt.setString(2, ename);
			
			cstmt.executeUpdate();
			System.out.println("업데이트 후 커밋 진행");
			commit(conn);
		} catch (SQLException e) {
			System.out.println("오류 발생하여 롤백 진행");
			rollback(conn);
			e.printStackTrace();
		} finally {
			Close(cstmt);
			Close(conn);
		}

	}

}
