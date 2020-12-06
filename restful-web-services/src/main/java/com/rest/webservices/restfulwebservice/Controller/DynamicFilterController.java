package com.rest.webservices.restfulwebservice.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilterController {

	@GetMapping("/dynamicfiltering")
	public MappingJacksonValue  getFilterBean() {

	FilterBean filterBean=new FilterBean(102, "Aadhya", "Java");
	SimpleBeanPropertyFilter filter = 
			          SimpleBeanPropertyFilter.filterOutAllExcept("name","course");
	FilterProvider filters =new SimpleFilterProvider().addFilter("filterBean", filter);
	MappingJacksonValue mapping =new MappingJacksonValue(filterBean);
	mapping.setFilters(filters);
	return mapping;
	
	}
	
	@GetMapping("/dynamicfilteringlist")
	public  MappingJacksonValue getFilterBeanlist()
	{
	   List<FilterBean>	list =Arrays.asList(new FilterBean(101, "rukesh", "java"),
	             new FilterBean(102, "nani", "java"));
	
		FilterBean filterBean=new FilterBean(102, "Aadhya", "Java");
		SimpleBeanPropertyFilter filter = 
				          SimpleBeanPropertyFilter.filterOutAllExcept("name","course");
		FilterProvider filters =new SimpleFilterProvider().addFilter("filterBean", filter);
		MappingJacksonValue mapping =new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return  mapping;
	}
}
