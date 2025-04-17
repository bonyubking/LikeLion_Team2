package com.workshop14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static common.JDBCTemplate.*;

public class Test01 {
	
	public static void main(String[] args) {
	
		Connection conn = getConnection();
		
		// 제품이 생산된 공장위치가 "SEOUL"인 제품 중 판매점에 재고가 없는 상품을 출력한다.
		// 재고 수량이 '0' or null / null인 경우 '0'으로 표기
		String sql = "SELECT P.PDNAME, P.PDSUBNAME, F.FACNAME, S.STONAME, S.STAMOUNT "
					 + "FROM PRODUCT P JOIN STORE S ON P.PDNO = S.PDNO "
		             + "JOIN FACTORY F ON P.FACTNO = F.FACTNO "
		             + "WHERE F.FACLOC = 'SEOUL' AND (S.STAMOUNT IS NULL OR S.STAMOUNT = 0)";

	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	    	pstmt = conn.prepareStatement(sql);
	    	rs = pstmt.executeQuery();
            System.out.println("  제품카테고리        제품명            공장명         판매점     판매점재고수량 ");
            System.out.println("------------+--------------+----------------+-----------+-------------");
	    	
	    	while (rs.next()) {
                String pdname = rs.getString("P.PDNAME");
                String pdsubname = rs.getString("P.PDSUBNAME");
                String facname = rs.getString("F.FACNAME");
                String stoname = rs.getString("S.STONAME");
                int stamount = rs.getInt("S.STAMOUNT");
                
                System.out.printf("%10s  %15s   %10s %10s %10d\n", pdname, pdsubname, facname, stoname, stamount);
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