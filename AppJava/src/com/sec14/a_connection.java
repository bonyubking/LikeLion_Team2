package com.sec14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class a_connection {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost:3306/my_emp";
			String user = "mydb";
			String password="chlwlgns9754@";
//		    conn =
//		       DriverManager.getConnection("jdbc:mysql://localhost:3306/my_emp?" +
//		                                   "user=mydb&password=chlwlgns9754@");
		    conn = DriverManager.getConnection(url,user,password);

		    if(!conn.isClosed()) {
		    	System.out.println("연결 중");
		    }


		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
