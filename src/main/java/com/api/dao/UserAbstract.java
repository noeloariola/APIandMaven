package com.api.dao;

import java.sql.SQLException;
import java.util.List;

import com.api.model.User;

public abstract class UserAbstract {

	public abstract List<User> getAllUser() throws SQLException;
	public abstract List<User> addUser(User user) throws SQLException ;
	public abstract void getUser(String id);
	public abstract void updateUser(String id);
	public abstract void deleteUser(String id);
	
	public abstract String hashPassword(String password);
	
}
