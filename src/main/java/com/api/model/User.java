package com.api.model;

public class User {
	private String id, username, password, type, contact;

	public User() {
		super();
	}
	
	public User(String id, String username, String password, String type, String contact) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.type = type;
		this.contact = contact;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	
}
