package com.workshop14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;

public class Num05 {
	
	public static void main(String[] args) {
	
		Connection conn = JDBCTemplate.getConnection();
		
		String sql ="DELETE FROM PRODUCT "+
					"WHERE PDNO IN ( "+
					"SELECT PDNO FROM DISCARDED_PRODUCT); ";	

		
				            

	    
	    PreparedStatement pstmt = null;

	    
	    try {
	    	
            conn.setAutoCommit(false);
	    	
	    	pstmt = conn.prepareStatement(sql);
	    	int rs = pstmt.executeUpdate();
		    
	    	
	    	if (rs > 0) {
		    	conn.commit();
		    	System.out.println(rs + "개의 데이터가 정상적으로 DELETE 되었습니다.");
		    	
		    }else {
		    	System.out.println("쿼리 오류");
		    	conn.rollback();
		    }
		   

	    	
	    	
	    } catch(SQLException e) {
	    	e.printStackTrace();
	    }	
	    
	    	finally {
	    		JDBCTemplate.Close(conn);
	    		JDBCTemplate.Close(pstmt);

	    	}
	}
		
}
	
