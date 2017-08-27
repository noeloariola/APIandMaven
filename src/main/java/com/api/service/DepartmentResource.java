package com.api.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import com.api.dao.DepartmentAbst;
import com.api.dao.DepartmentImplem;

import com.api.model.Department;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

@Stateless
@Path("/department")
public class DepartmentResource {
	
	
	private DepartmentAbst department;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response get() throws SQLException {
		department = new DepartmentImplem();
		List<Department> list = department.getAllDepartment();
		Gson gson = new Gson();
		String toJsonType = gson.toJson(list);
		System.out.println(toJsonType);
		System.out.println("HTTP GET");
		return Response.ok(toJsonType).build();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response gets(@PathParam("id") Integer id) throws SQLException {
		department = new DepartmentImplem();
		List<Department> dep = department.getDepartment(id);
		Gson gson = new Gson();
		String toJsonType = gson.toJson(dep);	
		System.out.println("HTTP GET WITH PARAM");
		return Response.ok(toJsonType).build();
	}	

	@Path("/add")
	@POST
	@Consumes("application/x-www-form-urlencoded") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(String title) throws SQLException{
		System.out.println(title +" **********");
		Gson gson = new Gson();
//		JsonElement jsonElement = gson.fromJson(title, JsonElement.class);
//		JsonObject response = jsonElement.getAsJsonObject();
		@SuppressWarnings("unchecked")
		Map<String, String> arrs = gson.fromJson(title, HashMap.class);
		
		System.out.println(arrs.get("title"));
		
		department = new DepartmentImplem();
		department.post(arrs.get("title"));
		List<Department> list = department.getAllDepartment();
		String toJsonType = gson.toJson(list);
		System.out.println("HTTP GET WITH PARAM");
		return Response.ok(toJsonType).build();
	}		
//	
	@Path("/update")
	@PUT
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Response put(String title) throws SQLException {
		System.out.println(title);
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		Map<String, String> arrs = gson.fromJson(title, HashMap.class);
		System.out.println(arrs.get("id"));
		department = new DepartmentImplem();
		
		List<Department> list = department.put(Integer.parseInt(arrs.get("id")), arrs.get("title"));
		String toJsonType = gson.toJson(list);
		return Response.ok(toJsonType).build();
	}	
//
//	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id") Integer id) throws SQLException {
		department = new DepartmentImplem();
		department.delete(id);
		System.out.println("HTTP DELETE");
	}	
//		
}
