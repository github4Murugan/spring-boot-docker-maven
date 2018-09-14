package com.axcess.it.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;

@Controller
@Path("/docker")
public class HelloController2 {

	@GET
	@Path("/hello")
	@Produces({MediaType.APPLICATION_JSON_PATCH_JSON})
	public String hello() {
	return "Hello from Docker Spring Boot Application...";	
	}
}
