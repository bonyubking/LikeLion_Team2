package Workshop14.workshop.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FactoryDAO {
	public void getFactoryAll(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from factory";
			rs = stmt.executeQuery(sql);
			
			System.out.printf("%-5s %-10s %-8s\n","공장번호","공장명","공장위치");
			System.out.println("----------------------------------");
			while(rs.next()) {
		    	System.out.println(rs.getString("factno")+"\t"+rs.getString("facname")+"\t"+rs.getString("facloc"));
		    }
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}

}
