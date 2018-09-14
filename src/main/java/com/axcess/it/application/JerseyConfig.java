package com.axcess.it.application;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.reflections.Reflections;
import org.springframework.web.filter.RequestContextFilter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JerseyConfig extends ResourceConfig{

	public JerseyConfig() {
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		
		JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
		provider.setMapper(mapper);
		
		register(provider);
		register(RequestContextFilter.class);
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		
		packages("com.axcess.it");
		
//		Reflections reflections = new Reflections("");
	
	}
}
