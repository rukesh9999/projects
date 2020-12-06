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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.main.model.Employee;
import com.employee.main.services.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	
	private EmployeeService employeeService;
	
	
	@Autowired
    public EmployeeRestController(EmployeeService EmployeeService) {
	
		this.employeeService = EmployeeService;
	}



	
	  @GetMapping(value ="/employees")
	  public List<Employee> findAll() {
		  
	  return employeeService.findAll(); 
	  
	  }
	  
	  
	  @RequestMapping("/employees/{employeeId}")
	  public Employee findEmployeeById(@PathVariable("employeeId") int id) 
	  {
		  Employee employee =   employeeService.findEmployeeById(id);
		  if(employee==null)
		  {
			  throw new RuntimeException("id not found...."+id);
		  }
		  return employeeService.findEmployeeById(id);
	  }
	  
	  
	  @PostMapping("/employees")
	  public Employee addEmployee(@RequestBody Employee employee)
	  {
		   employee.setId(0);
		   employeeService.save(employee);
		   return employee;
	  }
	 
	 
	 @DeleteMapping("/employees/{employeeId}")
	 public String deleteEmployeeById(@PathVariable("employeeId") int id)
	 {
		Employee employee = employeeService.findEmployeeById(id);
		if(employee==null)
		{
			throw new RuntimeException("Employee id is not found.."+id);
		}
		
		employeeService.deleteById(id);
		return "Deleted employee id..."+id;
		
	 }
	 
	 
	 @PutMapping("/employees")
	 public Employee updateemployee(@RequestBody Employee employee)
	 {
		 employeeService.save(employee);
		 return employee;
	 }
}
