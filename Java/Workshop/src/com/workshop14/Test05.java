package com.workshop14;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test05 {
	public static void main(String[] args) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM PRODUCT "
				     + "WHERE PDNO IN ( "
				     	+ "SELECT PDNO FROM DISCARDED_PRODUCT) ";

	    try {	
	    	conn.setAutoCommit(false);  // JDBCTemplate.java에 명시되어 있어 생략 가능
	    	
	    	pstmt = conn.prepareStatement(sql);
	    	int rs = pstmt.executeUpdate();
	    	
	    	if(rs > 0) {
	    		commit(conn);
	    		System.out.println(rs + "개의 데이터가 정상적으로 DELETE 되었습니다.");
	    	} else {
	    		System.out.println("DELETE 과정에서 오류가 발생하였습니다.");
	    		rollback(conn);
	    	}
	    } catch(SQLException e) {
	    	e.printStackTrace();
	    } finally {
	    	close(conn);
	    	close(pstmt);
	    }
	}
}
