package com.workshop14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;

public class Num02 {
	
	public static void main(String[] args) {
	
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT P.PDSUBNAME AS 제품명, P.PDCOST AS 제품원가, P.PDPRICE AS 제품가격 "+
				"FROM PRODUCT P WHERE (P.PDNAME = 'TV' AND P.PDCOST > (SELECT MIN(PDCOST) "+ 
				"FROM PRODUCT 	WHERE PDNAME = 'TV')) OR " +
		        "(P.PDNAME = 'CELLPHONE' AND P.PDCOST < (SELECT MAX(PDCOST) "+					
				"FROM PRODUCT WHERE PDNAME = 'CELLPHONE')) ";		

		
				            

	    
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	    	
	    	pstmt = conn.prepareStatement(sql);
	    	rs = pstmt.executeQuery();
            System.out.println("제품명    제품원가   제품가격");
            System.out.println("------+--------+--------");
	    	
	    	while (rs.next()) {
	    		
                String pdName = rs.getString("제품명");
                Integer pdCost = rs.getInt("제품원가");
                Integer pdPrice = rs.getInt("제품가격");

                

                System.out.printf("%s %10d %d \n",
                        pdName, pdCost, pdPrice);
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
