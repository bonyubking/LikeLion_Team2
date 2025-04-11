package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.transform.Result;

import static comm.JDBCTemplate.*; //자주 사용하는 정적메소드를 클래스명 없이 바로 참조해서 호출 

public class e_procInOut {

	public static void main(String[] args) {
		//연결확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;

		try {
			String sql = "{ call PRO09_SALARY_BONUS(?) } ";
			cstmt = conn.prepareCall(sql);
			
			int empno = 3;
			
			//데이터 바인딩
			cstmt.setInt(1, empno); // IN 부분 
			cstmt.registerOutParameter(1,java.sql.Types.INTEGER); //out 부분 
			
			
			// 실행
			cstmt.execute();
			
			//OUT 부분 리턴 값 출력
			int res = cstmt.getInt(1);
			System.out.println("사원번호: "+empno+" 의 예상 보너스 ="+res);
			
			System.out.println("출력완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(cstmt);
			Close(conn);
		}

	}

}
