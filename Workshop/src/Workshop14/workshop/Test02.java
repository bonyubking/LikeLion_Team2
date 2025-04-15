package Workshop14.workshop;

import static comm.JDBCTemplate.Close;
import static comm.JDBCTemplate.getConnection;
import static comm.JDBCTemplate.rollback;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test02 {

	public static void main(String[] args) {
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "{call test02()}";
			cstmt = conn.prepareCall(sql);
			
			rs = cstmt.executeQuery();
			
			System.out.printf("%-10s %-8s %-8s\n", "제품명","제품원가","제품가격");
			System.out.println("-------------------------------");
			
			while(rs.next()) {
				String pdsubname = rs.getString("PDSUBNAME");
				int pdcost = rs.getInt("PDCOST");
				int pdprice = rs.getInt("PDPRICE");

				System.out.printf("%-10s %-8d %-8d \n",pdsubname, pdcost,pdprice);
			}

		} catch (SQLException e) {
			// 오류가 발생했으므로 rollback 
			System.out.println("오류 발생하여 rollback 진행");
			rollback(conn);
			e.printStackTrace();
		} finally {
			try {
				cstmt.close();
				Close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

	}

}
