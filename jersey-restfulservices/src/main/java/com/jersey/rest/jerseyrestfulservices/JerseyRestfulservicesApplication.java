package com.jersey.rest.jerseyrestfulservices;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jersey.rest.jerseyrestfulservices.dao.EmployeeDao;
import com.jersey.rest.jerseyrestfulservices.model.Employee;

@SpringBootApplication
public class JerseyRestfulservicesApplication {

	@Autowired
	private EmployeeDao employeeDao;
	
	@PostConstruct
	public void init()
	{
		employeeDao.deleteAll();
		employeeDao.saveAll
		(Stream.of(new Employee(101, "rukesh", "dev"),
				new Employee(102, "nani", "engineering"),
				new Employee(103, "Mona", "HR"),
				new Employee(104, "zeenam", "HR"),
				new Employee(105, "amar", "dev"),
				new Employee(106, "eureka", "dev"),
				new Employee(107, "ribbon", "HR"),
				new Employee(108, "zulu", "dev"),
				new Employee(109, "sravs", "dev"),
				new Employee(110, "roopa", "HR"),
				new Employee(111, "config", "HR"),
				new Employee(112, "apigateway", "HR"),
				new Employee(113, "hystix", "HR"))
				.collect(Collectors.toList()));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JerseyRestfulservicesApplication.class, args);
	  }

}
