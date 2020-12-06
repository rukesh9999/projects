package com.spf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewRendererServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.spf.controller"})
public class MvcConfig  extends WebMvcConfigurerAdapter{

	public void configureViewResolvers(ViewResolverRegistry registry)
	{
		registry.jsp().prefix("/WEB-INF/jsps/").suffix(".jsp");
	}
	
	
	  public void addViewControllers(ViewControllerRegistry registry) 
	  {
	    registry.addViewController("/planDetails").setViewName("planDetails");
	  }
	 

}
