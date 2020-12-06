package com.crm.rest.controllers;

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

import com.crm.rest.entity.Customer;
import com.crm.rest.exceptionhandling.CustomerNotFoundException;
import com.crm.rest.services.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService CustomerService;

	// add mapping for get customers
	@GetMapping(value = "/customers")
	public List<Customer> listOfCustomers() {
		List<Customer> listOfCustomers = CustomerService.getCustomers();
		return listOfCustomers;
	}
	
	
	  //add mapping for get customer
	  @GetMapping("/customers/{customerId}")
	  public Customer  getCustomer(@PathVariable int customerId) 
	  { 
		 Customer customer = CustomerService.getCustomer(customerId); 
		 if(customer==null)
		 {
			 throw new CustomerNotFoundException("customer id not found -"+customerId);
		 }
		 return  customer;
	   }
	
	   
	   //add mapping for post customer- add new customer
	   @PostMapping("/customers") 
	   public Customer saveCustomer(@RequestBody Customer customer) 
	   {
		 //pass id in json....set id to json
		 //this is for sava a new customer instead of update
		 customer.setId(0);
		 CustomerService.saveCustomer(customer); 
		 return  customer; 
		 
	   }
		
	   
	   //add mapping for put customer- update the Existing customer
	   @PutMapping("/customers") 
	   public Customer updateCustomer(@RequestBody Customer customer) 
	   {
		 
		 CustomerService.saveCustomer(customer); 
		 return  customer; 
		 
	   }
	  
	   
	     //add mapping for delete customer- delete the Existing customer
		  @DeleteMapping("/customers/{customerId}")
		  public String deleteCustomer(@PathVariable int customerId)
		  {
			 Customer Customer =  CustomerService.getCustomer(customerId);
			 
			 //throw exception  if null
			 if(Customer==null)
			 {
				 throw new CustomerNotFoundException("customer id not found..."+customerId);
			 }
		     CustomerService.deleteCustomer(customerId); 
		     
		     return "Deleted customer id..."+customerId; 
		    
		  }
		 
}
