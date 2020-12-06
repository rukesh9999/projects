package com.rest.webservices.restfulwebservice.Controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservice.dto.HelloWorldBean;

@RestController
public class HelloWorldController {

	@Autowired
	@Qualifier("resourceBundleMessageSource")
	private MessageSource MessageSource;
	
	
	@GetMapping("/hello-world")
	public String helloworld()
	{
		return "Hello-world";
	}
	
	@GetMapping("/hello-world-bean")
	private HelloWorldBean helloworldBean()
	{
	   return new HelloWorldBean("hello-world-bean");	
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	private HelloWorldBean helloworldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Hello world...,%s",name));
	}
	
	@GetMapping("/hello-world-internationalization")
	private String helloworldPathVariable(@RequestHeader(name = "Accept-language",required = false) Locale locale)
	{
		return MessageSource.getMessage("good.morning.message",null, locale);
	}
	
	@GetMapping("/hello-world-internationalization2")
	private String helloworldPathVariable2()
	{
		return MessageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
}


