package com.jersey.rest.jerseyrestfulservices.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.jersey.rest.jerseyrestfulservices.resource.EmployeeResource;

@Configuration
public class RestConfig extends ResourceConfig{

	@Override
	public ResourceConfig register(Class<?> componentClass) {
		return super.register(EmployeeResource.class);
	}

	
}
