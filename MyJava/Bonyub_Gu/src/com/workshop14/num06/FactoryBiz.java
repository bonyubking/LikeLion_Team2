package com.workshop14.num06;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import common.JDBCTemplate;

public class FactoryBiz {
	
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	
	public FactoryBiz() {
		
	}
	
	public FactoryBiz(String driver, String url, String user, String pass) {
		super();
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
		Properties prop = new Properties();
		
		try (InputStream input = JDBCTemplate.class.getClassLoader().getResourceAsStream("db.properties")){
			
			if (input == null) {
				throw new RuntimeException("db.properties 없음");
			}
			
			prop.load(input);
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			
		    Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		    
		    conn.setAutoCommit(false);
		    
		    
		    FactoryDAO FD = new FactoryDAO();
		    FD.getFactoryAll(conn);
		    
		}	catch(Exception e) { 
		    e.printStackTrace();}
		
		finally {
			JDBCTemplate.Close(conn);
		}
	

		
	}
	

	
}
