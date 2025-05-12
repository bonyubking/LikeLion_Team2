package com.sec15.procedureTest;

import static common.JDBCTemplate.Close;
import static common.JDBCTemplate.getConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class GuGuDan2_proc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력 : ");
		int p_dan = sc.nextInt();
		
		// 연결확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "{ call 03_GuGuDan(?) }";
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, p_dan);
			
			rs = cstmt.executeQuery();
			
			while(rs.next()) {
				String lst = rs.getString("GuGuDan_PRN");
				
				System.out.printf("%10s\n", lst);
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
