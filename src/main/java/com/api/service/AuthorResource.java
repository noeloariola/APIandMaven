package com.api.service;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.api.model.Author;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.org.apache.xerces.internal.impl.dv.DatatypeValidator;
import com.sun.org.apache.xerces.internal.impl.dv.InvalidDatatypeValueException;
import com.sun.org.apache.xerces.internal.impl.dv.ValidationContext;

@Stateless
@Path("/author")
public class AuthorResource {
	
	
//	private AuthorInter ai = new AuthorImple();
	String jsonText = "";
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		Author a1 = new Author(1, "Wel", "oliveors", "ariola");
		Author a2 = new Author(2, "Bin", "kepler", "jin");
		List<Author> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		
		Gson gson = new Gson();
		String toJsonType = gson.toJson(list);
		
//		String newJson = toJsonType.replace("[", "");
//		newJson = newJson.replace("]", "");
//		jsonText = toJsonType;
//		newJson = "{ "+ "  \"authors\": "+" [ " + newJson + " ] }";
//		newJson = "{ "+ "  \"authors\": "+" [ " + newJson + " ] }";
		System.out.println(toJsonType);
		return Response.ok(toJsonType).build();
	}

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") Integer id) {
		Author a1 = new Author(1, "Wel", "oliveors", "ariola");
		Author a2 = new Author(2, "Bin", "kepler", "jin");
		List<Author> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		
		Author distictAuthor = null;	
		
		Gson gson = new Gson();
		System.out.println("Get boolean:" + isValidId(id));
		
		for(Author author : list){
			if(author.getId() == id){
				distictAuthor = author;
				break;
			}
		}
		if(distictAuthor == null){
			String notFound = "{\"error\": \"Id does not exist!\"}";
			return Response.ok(notFound).build();
		}

		String jsonDistinctAuthor = gson.toJson(distictAuthor);
		return Response.ok(jsonDistinctAuthor).build();
	}
	
	private <T> boolean isValidId(T param){
		System.out.println("Get Class: "+param.getClass().getSimpleName().toLowerCase());
		return param.getClass().getSimpleName().toLowerCase().equals("integer");
	}
	
}
