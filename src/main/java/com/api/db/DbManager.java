package com.api.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {
	private Connection conn = null;
	
	
	public Connection JDBCConnection() throws SQLException {
		String url = "jdbc:postgresql://192.168.1.7:5432/payroll";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","admin123");
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, props);
			System.out.println("Postgre connection established!");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
//	public Connection JDBCConnection() throws SQLException {
//		try{
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll", "root", "admin");
//		}catch(Exception e){
//			System.out.println("catch");
//		}
//		return conn;
//	}
	
}
