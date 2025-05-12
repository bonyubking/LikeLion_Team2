package com.workshop14.num06;

import static common.JDBCTemplate.Close;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FactoryDAO {
	
	
	public void getFactoryAll(Connection con){
		
		

		Statement stmt = null;
		ResultSet rs = null;

		
		String select_sql = "SELECT * FROM FACTORY ";

		
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(select_sql);
			System.out.printf("%-10s %-20s %-20s \n","공장번호", "공장명", "공장위치");
			System.out.println();

			
			while (rs.next()) {

				
				System.out.printf("%-10s %-20s %-20s \n",rs.getString("FACTNO"), rs.getString("FACNAME"), rs.getString("FACLOC"));
			
		}
			
		} catch (SQLException e) {

			e.printStackTrace();
			
		} finally {
			
			Close(rs);
			Close(stmt);}
}
}
	
