package com.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.api.db.DbManager;
import com.api.model.Department;

public class DepartmentImplem extends DepartmentAbst{
	Connection conn = null;
	private DbManager dbManager = new DbManager();
	
	@Override
	public List<Department> getAllDepartment() throws SQLException {
		List<Department> list = new ArrayList<>();
		conn =  dbManager.JDBCConnection();
		String sql = "SELECT id, title FROM public.department";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			Department dep = new Department();
			dep.setId(rs.getInt("id"));
			dep.setTitle(rs.getString("title"));
			list.add(dep);
		}
		
		return list;
	}
	
	@Override
	public List<Department> getDepartment(int id) throws SQLException {
		List<Department> list = new ArrayList<>();
		conn =  dbManager.JDBCConnection();
		String sql = "SELECT id, title FROM department WHERE id = "+id+"";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			Department dep = new Department();
			dep.setId(rs.getInt("id"));
			dep.setTitle(rs.getString("title"));
			list.add(dep);
		}
		return list;
	}

	@Override
	public void post(String title) throws SQLException {
		System.out.println("POST METHOD______________________________________");
		String sql = "INSERT INTO public.department(title)values(?)";
		conn =  dbManager.JDBCConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		
			
		
		pst.setString(1, title);
		pst.executeUpdate();
	}

	@Override
	public List<Department> put(int id, String title) throws SQLException {
		String sql = "UPDATE department set title = '"+title+"' WHERE id = '"+id+"' ";
		conn =  dbManager.JDBCConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.executeUpdate();
		return getAllDepartment();
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM department WHERE id = '"+id+"' ";
		conn =  dbManager.JDBCConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.executeUpdate();
	}
	
	
	
}
