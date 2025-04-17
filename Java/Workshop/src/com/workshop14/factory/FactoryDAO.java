package com.workshop14.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FactoryDAO {

    public void getFactoryAll(Connection conn) {
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
        String sql = "SELECT FACTNO, FACNAME, FACLOC FROM FACTORY";

        try {
        	pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("   공장번호          공장명          공장위치");
            System.out.println("-------------------------------------------");

            while (rs.next()) {
                int factno = rs.getInt("FACTNO");
                String facname = rs.getString("FACNAME");
                String facloc = rs.getString("FACLOC");

                System.out.printf("    %5d      %10s %10s \n", factno, facname, facloc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
    }
}
