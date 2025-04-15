package Workshop14.workshop.factory;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

import comm.JDBCTemplate;

public class Test06 {

	public static void main(String[] args) {
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
			
			FactoryBiz fac = new FactoryBiz(driver, url, user, password);
			fac.getFactoryAll();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		FactoryBiz fac = new FactoryBiz();
		

	}

}
