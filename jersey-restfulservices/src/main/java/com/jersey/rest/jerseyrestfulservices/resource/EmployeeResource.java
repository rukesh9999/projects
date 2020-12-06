package com.jersey.rest.jerseyrestfulservices.resource;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jersey.rest.jerseyrestfulservices.dao.EmployeeDao;
import com.jersey.rest.jerseyrestfulservices.model.Employee;

@Path("/rest")
public class EmployeeResource {
    
	 private static final Optional<Employee> ResponseEntity = null;
	@Autowired
	 private EmployeeDao employeeDao;
	 
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path("/save")
	 public Employee saveEmployee(Employee employee)
	 {
		 return employeeDao.save(employee);
	 }
	 
	 
	 @GET
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path("/getemployees")
	 public Pageable getAllEmployees()
	 {
		 
		// return employeeDao.findAll(Sort.by(Sort.Direction.DESC, "name")); 
		// Sort sort= Sort.by(Sort.Direction.DESC, "name");
		 PageRequest page=PageRequest.of(0,3);
		 Page<Employee>  firstpage  = employeeDao.findAll(page); 
		 System.out.println(firstpage);
		 return firstpage.nextPageable(); 
	 }
	 
	 @GET	
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path("/getemployee/{name}")
	 public Employee getEmployee(@PathParam("name") String name)
	 {
		 return employeeDao.findByName(name);
	 }
	 
	 @PUT
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path("/update/{id}")
	 public Employee updateEmployee(@PathParam("id") int id , Employee employee)
	 {
		 employee.setId(id);
		 return employeeDao.save(employee);
	 }
	
	 @DELETE
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path("/delete/{id}")
	 public void deleteEmployee(@PathParam("id") int id)
	 {
		   Optional<Employee> employee= employeeDao.findById(id);
		   if(employee!=null)
		   {
			     employeeDao.deleteById(id);
		   }
		  
		 
	 }
	 
	 
}
