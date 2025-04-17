package com.workshop14.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

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
	    try (InputStream is = new FileInputStream("D:\\likelion\\myWork\\MyJava\\Workshop\\src\\db.properties")) {
	        Properties prop = new Properties();
	        prop.load(is);

	        this.driver = prop.getProperty("driver");
	        this.url = prop.getProperty("url");
	        this.user = prop.getProperty("user");
	        this.pass = prop.getProperty("password");

	        Connection conn = null;

	        try {
	            Class.forName(driver);
	            conn = DriverManager.getConnection(url, user, pass);
	            conn.setAutoCommit(false);

	            FactoryDAO dao = new FactoryDAO();
	            dao.getFactoryAll(conn);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	try {
	        		conn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}