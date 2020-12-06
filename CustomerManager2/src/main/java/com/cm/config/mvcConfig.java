package com.cm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.cm.controllers"})
public class mvcConfig  extends WebMvcConfigurerAdapter{
  
	
	
	public void configureViewResolvers(ViewResolverRegistry registry)
	{
		
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	
	
	
}
