package com.api;

import java.io.IOException;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {
 
    @Override
    public void filter(final ContainerRequestContext requestContext,
            final ContainerResponseContext responseContext) throws IOException {
        final MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
//        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Allow-Headers","Access-Control-Allow-Origin, content-type, accept, authorization, X-Requested-With, Access-Control-Request-Method, Access-Control-Request-Headers");
//        headers.add("Access-Control-Allow-Headers","X-Requested-With, Content-Type, X-Auth-Token");
        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
          System.out.println("response filter");
    }
}

@Provider
class CorsRequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(final ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getRequest().getMethod().equals(HttpMethod.OPTIONS)) {
			requestContext.abortWith(Response.status(Response.Status.OK).build());
			System.out.println("request filter");
		}
	}
}