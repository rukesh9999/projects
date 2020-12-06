package com.rest.webservices.restfulwebservice;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(RestfulWebServicesApplication.class, args);

	}
	
	@Bean
	public AcceptHeaderLocaleResolver getLocaleResolver2()
	{
		
		AcceptHeaderLocaleResolver localeResolvers =new AcceptHeaderLocaleResolver();
		localeResolvers.setDefaultLocale(Locale.US);
	    return localeResolvers;
	}

	
	@Bean
	public SessionLocaleResolver getLocaleResolver()
	{
		SessionLocaleResolver localeResolvers =new SessionLocaleResolver();
		localeResolvers.setDefaultLocale(Locale.US);
	    return localeResolvers;
	}
	
	@Bean(name = "resourceBundleMessageSource")
	public ResourceBundleMessageSource getResourceBundleMessageSource()
	{
		ResourceBundleMessageSource resourceBundleMessageSource = new  ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("messages");
		return resourceBundleMessageSource;
	}

}
