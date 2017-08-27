package com.api.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
	private Connection conn = null;
	
	public Connection JDBCConnection() throws SQLException {
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll", "root", "admin");
		}catch(Exception e){
//			e.printStackTrace();
			System.out.println("catch");
//			if(conn != null){
//				System.out.println("rollback");
//				conn.rollback();
//			}
		}
//		finally {
//			System.out.println("Finally");
//			if(conn != null){
//				System.out.println("conn != null");
//				conn.close();
//			}
//			conn.setAutoCommit(true);
//		}
		
		return conn;
	}
	
}
