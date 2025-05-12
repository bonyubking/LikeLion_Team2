package com.sec14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class a_connection {
	public static void main(String[] args) {
		
		Connection conn = null;
		try {
			
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_emp?" + "user=root&password=kus951024*");

		    if (!conn.isClosed()) {
		    	System.out.println("연결 중이야");
		    }
		    
		} catch (SQLException ex) {
		   
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}