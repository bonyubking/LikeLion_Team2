package com.workshop14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;

public class Num01 {
	
	public static void main(String[] args) {
	
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT P.PDNAME AS 제품카테고리, P.PDSUBNAME AS 제품명, "
		        + "F.FACNAME AS 공장명, S.STONAME AS 판매점명, IFNULL(S.STAMOUNT, 0) AS 판매점재고수량 "
		        + "FROM PRODUCT P JOIN STORE S ON P.PDNO = S.PDNO "
		        + "JOIN FACTORY F ON P.FACTNO = F.FACTNO "
		        + "WHERE F.FACLOC = 'SEOUL' AND (S.STAMOUNT IS NULL OR S.STAMOUNT = 0)";

	    
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	    	
	    	pstmt = conn.prepareStatement(sql);
	    	rs = pstmt.executeQuery();
            System.out.println("제품카테고리    제품명   공장명   판매점  판매점재고수량 ");
            System.out.println("-----------+------+------+------+-----------+");
	    	
	    	while (rs.next()) {
	    		
                String pdName = rs.getString("제품카테고리");
                String pdSubName = rs.getString("제품명");
                String facName = rs.getString("공장명");
                String stoName = rs.getString("판매점명");
                int stAmount = rs.getInt("판매점재고수량");
                

                System.out.printf("%s %10s %10s %10s %d\n",
                        pdName, pdSubName, facName, stoName, stAmount);
	    	}
	    	
	    } catch(SQLException e) {
	    	e.printStackTrace();
	    }	
	    
	    	finally {
	    		JDBCTemplate.Close(rs);
	    		JDBCTemplate.Close(conn);
	    		JDBCTemplate.Close(pstmt);
	    	}
	    
		
		

	}

}
