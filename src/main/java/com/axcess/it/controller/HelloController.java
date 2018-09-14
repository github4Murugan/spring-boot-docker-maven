package com.axcess.it.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docker1/hello")
public class HelloController {

	@GetMapping
	public String hello() {
	return "Hello from Docker Spring Boot Application...";	
	}
}
