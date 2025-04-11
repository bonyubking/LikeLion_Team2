package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import static comm.JDBCTemplate.*; //자주 사용하는 정적메소드를 클래스명 없이 바로 참조해서 호출 

public class a_proc {

	public static void main(String[] args) {
		//연결확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		
		try {
			String sql = "{call PRO01_INSERT()}";
			cstmt = conn.prepareCall(sql);
			
			// 오류가 발생하지 않을 경우 아래 commit 실행 
			cstmt.execute(); // 프로시저 실행 
			commit(conn);
			System.out.println("프로시저 실행 후 commit 완료");
		} catch (SQLException e) {
			// 오류가 발생했으므로 rollback 
			System.out.println("오류 발생하여 rollback 진행");
			rollback(conn);
			e.printStackTrace();
		} finally {
			try {
				cstmt.close();
				Close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
