package Workshop14.workshop.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryBiz {
	String driver;
	String url;
	String user;
	String pass;
	
	public FactoryBiz() {}
	public FactoryBiz(String driver, String url, String user, String pass) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pass = pass;
	}
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void getFactoryAll() {
		Connection conn = null;

		try {
			Class.forName(driver); //리소스 로드 시 반드시 명시해야함 
			conn = DriverManager.getConnection(url,user,pass); 
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		FactoryDAO factoryDAO = new FactoryDAO();
		factoryDAO.getFactoryAll(conn);
	}

}
