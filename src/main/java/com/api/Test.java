package com.api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;  

import org.glassfish.jersey.client.ClientConfig;

public class Test {
	
//	private static void runPutRequest(WebResource service,String path){
//        String ressponse = service.path("rest/catalog/"+path).accept(MediaType.APPLICATION_XML).put(String.class);
//        System.out.println("Post Response :"+response);
//    }
//	
	public static void main(String args[]){
		ClientConfig config = new ClientConfig();  
	    Client client = ClientBuilder.newClient(config);  
	    WebTarget target = client.target(getBaseURI()); 
	    

	    System.out.println(target.path("api").path("department").request().accept(MediaType.TEXT_PLAIN).get(String.class));  
	    System.out.println(target.path("api").path("department").request().accept(MediaType.TEXT_XML).get(String.class));  
	    System.out.println(target.path("api").path("department").request().accept(MediaType.TEXT_HTML).get(String.class));

	    System.out.println(target.path("api").path("department").request().accept(MediaType.APPLICATION_JSON).get(String.class));  
	    
	}
	private static URI getBaseURI() {  
	    //here server is running on 4444 port number and project name is restfuljersey  
	    return UriBuilder.fromUri("http://localhost:8080/JAXRS/api/department").build();  
	}  
}
