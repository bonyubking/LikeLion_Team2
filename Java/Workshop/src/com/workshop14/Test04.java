package com.workshop14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static common.JDBCTemplate.*;

public class Test04 {
	public static void main(String[] args) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO DISCARDED_PRODUCT (PDNO, PDNAME, PDSUBNAME, FACTNO, PDDATE, PDCOST, PDPRICE, PDAMOUNT, DISCARDED_DATE) "
				+ "SELECT PDNO, PDNAME, PDSUBNAME, P.FACTNO, PDDATE, PDCOST, PDPRICE, PDAMOUNT, CURRENT_DATE() "
				+ "FROM PRODUCT P JOIN FACTORY F ON P.FACTNO = F.FACTNO "
				+ "WHERE F.FACLOC = 'CHANGWON' ";

	    try {	
	    	conn.setAutoCommit(false);  // JDBCTemplate.java에 명시되어 있어 생략 가능
	    	
	    	pstmt = conn.prepareStatement(sql);
	    	int rs = pstmt.executeUpdate();
	    	
	    	if(rs > 0) {
	    		commit(conn);
	    		System.out.println(rs + "개의 데이터가 정상적으로 INSERT 되었습니다.");
	    	} else {
	    		System.out.println("INSERT 과정에서 오류가 발생하였습니다.");
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
