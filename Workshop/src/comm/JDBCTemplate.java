package comm;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// DB 연결 생성, 자원 해제(Connection, Statement, ResultSet), 트랜잭션 처리(commit, rollback) 
public class JDBCTemplate {
	
	// case 2: DB 연결_properties 파일로 로드하는 방법 
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		try (InputStream input = JDBCTemplate.class.getClassLoader().getResourceAsStream("db_properties")){
			if(input == null) {
				throw new RuntimeException("db 파일 찾을 수 없음");
			}
			
			prop.load(input);
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			
			Class.forName(driver); //리소스 로드 시 반드시 명시해야함 
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("로드 완료");
			
			conn.setAutoCommit(false);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return conn;
	} 
	
	
	
	
	//DB close 
	public static void Close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println("데이터베이스 연결 닫기 오류 : "+e.getMessage());
			}
		}
		
	}
	
	//statements close 하는 곳 
	public static void Close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			}catch(SQLException e) {
				System.out.println("명령 오류 : "+e.getMessage());
			}
		}
		
	}
	
	//ResultSet close 
	public static void Close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
					System.out.println("쿼리 리턴 오류 : "+e.getMessage());
			}
		}
	}
	
	// 트랜잭션 처리 (commit)
	public static void commit(Connection conn) {
		if(conn != null) {
			try {
				conn.commit();
			}catch(SQLException e) {
					System.out.println("쿼리 리턴 오류 : "+e.getMessage());
			}
		}
	}
	
	// 트랜잭션 처리 (rollback) 
	public static void rollback(Connection conn) {
		if(conn != null) {
			try {
				conn.rollback();
			}catch(SQLException e) {
					System.out.println("쿼리 리턴 오류 : "+e.getMessage());
			}
		}
	}
}
