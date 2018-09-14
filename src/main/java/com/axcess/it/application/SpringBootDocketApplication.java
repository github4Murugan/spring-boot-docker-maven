package com.axcess.it.application;

import java.util.logging.Logger;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@PropertySource(value = "classpath:external_config.properties")
public class SpringBootDocketApplication {
	
	@Autowired
	private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDocketApplication.class, args);
	}
	
	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(),
				env.getProperty("servlet.base.resource.path"));
		
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
		
		return registration;
		
	}
}
