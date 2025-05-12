package com.sec14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class f_deletePrepared {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//연결
		try {
			
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_emp?" + "user=root&password=kus951024*");

		    if (!conn.isClosed()) {
		    	System.out.println("연결 중이야");
		    }
		    //명령 수행
		    conn.setAutoCommit(false);
		    
		    String sql_delete = "delete from emp where ename = ?;";
		    
		    pstmt = conn.prepareStatement(sql_delete);
		    pstmt.setString(1, "홍길동");
		   
		    
		    int res  = pstmt.executeUpdate();
		    if (res > 0) {
		    	conn.commit();
		    }else {
		    	System.out.println("쿼리 오류");
		    	conn.rollback();
		    }
		    
		    //2-2 select
		    String sql = "select * from emp;";
		    rs = pstmt.executeQuery(sql);
		    
		    // 결과 출력
		    while(rs.next()) {
		    	System.out.println(rs.getString("empno") + "\t" + rs.getString("ename"));
		    }
		    
		} catch (SQLException ex) {
		   
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}