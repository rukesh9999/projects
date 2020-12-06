package com.rest.webservices.restfulwebservice.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StaticFilterController {
	
	@GetMapping("/staticfiltering")
	public FilterBean getFilterBean()
	{
		return new FilterBean(101, "rukesh", "java");
	}
	
	
	@GetMapping("/staticfilteringlist")
	public  List<FilterBean> getFilterBeanlist()
	{
		return Arrays.asList(new FilterBean(101, "rukesh", "java"),
				             new FilterBean(102, "nani", "java"));
				
	}
}
