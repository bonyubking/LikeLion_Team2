package Workshop14.workshop;

import static comm.JDBCTemplate.Close;
import static comm.JDBCTemplate.commit;
import static comm.JDBCTemplate.getConnection;
import static comm.JDBCTemplate.rollback;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Test01 {

	public static void main(String[] args) {
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		
		try {
			String sql = "{call PRO01_INSERT()}";
			cstmt = conn.prepareCall(sql);
			
			// 오류가 발생하지 않을 경우 아래 commit 실행 
			cstmt.execute(); // 프로시저 실행 
			commit(conn);
			System.out.println("프로시저 실행 후 commit 완료");
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
