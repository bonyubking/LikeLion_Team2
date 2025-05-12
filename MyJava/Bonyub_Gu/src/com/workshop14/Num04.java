package com.workshop14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;

public class Num04 {
	
	public static void main(String[] args) {
	
		Connection conn = JDBCTemplate.getConnection();
		
		String sql ="INSERT INTO DISCARDED_PRODUCT ( " +
			    "PDNO, PDNAME, PDSUBNAME, FACTNO, PDDATE, "+
			    "PDCOST, PDPRICE, PDAMOUNT, DISCARDED_DATE) "+
			    "SELECT " + 
			    "PDNO, PDNAME, PDSUBNAME, P.FACTNO, PDDATE, "+
			    "PDCOST, PDPRICE, PDAMOUNT, CURRENT_DATE "+
			    "FROM PRODUCT P "+
			    "JOIN FACTORY F ON P.FACTNO = F.FACTNO "+
			    "WHERE F.FACLOC = 'CHANGWON'; ";		

		
				            

	    
	    PreparedStatement pstmt = null;

	    
	    try {
	    	
            conn.setAutoCommit(false);
	    	
	    	pstmt = conn.prepareStatement(sql);
	    	int rs = pstmt.executeUpdate();
		    
	    	
	    	if (rs > 0) {
		    	conn.commit();
		    	System.out.println(rs + "개의 제품 폐기 완료");
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
	
