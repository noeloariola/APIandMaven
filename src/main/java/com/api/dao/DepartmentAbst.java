package com.api.dao;

import java.sql.SQLException;
import java.util.List;

import com.api.model.Department;

public abstract class DepartmentAbst {
	
	public abstract List<Department> getAllDepartment() throws SQLException;
	public abstract List<Department> getDepartment(int id) throws SQLException;
	public abstract void post(String title) throws SQLException;
	public abstract List<Department> put(int id, String title) throws SQLException;
	public abstract void delete(int id) throws SQLException;
}
