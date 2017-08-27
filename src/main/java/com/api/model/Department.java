package com.api.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="department")
public class Department {
	
	private long id;
	private String title;
	

	public Department() {
		super();
	}
	
	public Department(long id) {
		super();
		this.id = id;
	}

	public Department(long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	@XmlElement
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
