package Workshop14.workshop;

import static comm.JDBCTemplate.Close;
import static comm.JDBCTemplate.getConnection;
import static comm.JDBCTemplate.rollback;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test04 {

	public static void main(String[] args) {
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "{call test04(?)}";
			cstmt = conn.prepareCall(sql);
			
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			
			cstmt.execute();
			int insertedCount = cstmt.getInt(1);
			System.out.println(insertedCount+"개의 데이터가 정상적으로 INSERT 되었습니다.");
			

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
