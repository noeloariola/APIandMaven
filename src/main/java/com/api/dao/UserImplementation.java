package com.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.api.db.DbManager;
//import com.api.model.User;
import com.mysql.jdbc.Statement;

public class UserImplementation{
//	Connection conn = null;
//	private DbManager dbManager = new DbManager();
//	
//	@Override
//	public List<User> getAllUser(){
		String sql = "SELECT * FROM user";
//		conn = dbManager.JDBCConnection();
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery(sql);
//		List<User> user = new ArrayList<>();
//		while(rs.next()){
//			
//		}
//		return user;
//	}

//	@Override
//	public List<User> addUser(User user) throws SQLException {
//		System.out.println("Add user");
//		String sql = "INSERT INTO departmentvalues(?,?,?,?,?)";
//		conn =  dbManager.JDBCConnection();
//		PreparedStatement pst = conn.prepareStatement(sql);
//		pst.setString(1, user.getId());
//		pst.setString(2, user.getUsername());
//		pst.setString(3, user.getPassword());
//		pst.setString(4, user.getType());
//		pst.setString(5, user.getContact());
//		pst.executeUpdate();
//		List<User> userList = new ArrayList<>();
//		return userList;
//	}

//	@Override
//	public void getUser(String id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void updateUser(String id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteUser(String id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public String hashPassword(String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
