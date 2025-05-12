package com.sec15.procedureTest;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.Close;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GetEmp_proc {
	public static void main(String[] args) {
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "{ call 01_GetEmp_Res() }";
			cstmt = conn.prepareCall(sql);
			rs = cstmt.executeQuery();
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int mgr = rs.getInt("mgr");
				int level = rs.getInt("level");
				
				System.out.printf("%5d %10s %5d %5d\n", empno, ename, mgr, level);
			}
			
			System.out.println(conn.isClosed());
			System.out.println("연결중.....");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(rs);
			Close(cstmt);
			Close(conn);
		}
	}
}
