package com.employee.main.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.main.daos.EmployeeDao;
import com.employee.main.model.Employee;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	
	private EmployeeDao employeeDao;
	
      @Autowired
	  public EmployeeRestController(EmployeeDao employeeDao) {
	
		this.employeeDao = employeeDao;
	}


	 @GetMapping(value ="/employees")
	  public List<Employee> findAll() {
		  
	  return employeeDao.findAll(); 
	  
	  }
	  
	  
	  @RequestMapping("/employees/{employeeId}")
	  public Employee findEmployeeById(@PathVariable("employeeId") int id) 
	  {
		  Employee employee =   employeeDao.findEmployeeById(id);
		  if(employee==null)
		  {
			  throw new RuntimeException("id not found...."+id);
		  }
		  return employeeDao.findEmployeeById(id);
	  }
	  
	  
	  @PostMapping("/employees")
	  public Employee addEmployee(@RequestBody Employee employee)
	  {
		   employee.setId(0);
		   employeeDao.save(employee);
		   return employee;
	  }
	 
	 
	 @DeleteMapping("/employees/{employeeId}")
	 public String deleteEmployeeById(@PathVariable("employeeId") int id)
	 {
		Employee employee = employeeDao.findEmployeeById(id);
		if(employee==null)
		{
			throw new RuntimeException("Employee id is not found.."+id);
		}
		
		employeeDao.deleteById(id);
		return "Deleted employee id..."+id;
		
	 }
	 
	 
	 @PutMapping("/employees")
	 public Employee updateemployee(@RequestBody Employee employee)
	 {
		 employeeDao.save(employee);
		 return employee;
	 }
}
