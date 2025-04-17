package com.workshop14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static common.JDBCTemplate.*;

public class Test02 {
	
	public static void main(String[] args) {
	
		Connection conn = getConnection();
		
		// 제품카테고리가 "TV"인 제품 중 가장 싼 것보다 비싼 모든 제품 AND 제품카테고리가 "CELLPHONE"인 제품 중 가장 비싼 제품보다 싼 모든 제품 출력
		// UNION 사용 금지 / 하나의 쿼리문 / 제품 원가 기준 
		String sql = "SELECT PDSUBNAME, PDCOST, PDPRICE FROM PRODUCT "
		             + "WHERE(PDNAME = 'TV' AND PDCOST > (SELECT MIN(PDCOST) FROM PRODUCT WHERE PDNAME = 'TV')) "
		             + "OR (PDNAME = 'CELLPHONE' AND PDCOST < (SELECT MAX(PDCOST) FROM PRODUCT WHERE PDNAME = 'CELLPHONE'))";

	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	    	pstmt = conn.prepareStatement(sql);
	    	rs = pstmt.executeQuery();
            System.out.println("    제품명        제품원가        제품가격");
            System.out.println("------------+------------+--------------");
	    	
	    	while (rs.next()) {
                String pdsubname = rs.getString("PDSUBNAME");
                int pdcost = rs.getInt("PDCOST");
                int pdprice = rs.getInt("PDPRICE");
                
                System.out.printf("%10s    %10d    %10d\n", pdsubname, pdcost, pdprice);
	    	}
	    } catch(SQLException e) {
	    	e.printStackTrace();
	    } finally {
	    	close(rs);
	    	close(conn);
	    	close(pstmt);
	    }
	}
}