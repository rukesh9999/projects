package com.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crm.entity.Customer;
import com.crm.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService CustomerService;

	@GetMapping(value = "/list")
	public ModelAndView listOfCustomers() {
		ModelAndView mv = new ModelAndView();
		List<Customer> listOfCustomers = CustomerService.getCustomers();
		mv.addObject("listOfCustomers", listOfCustomers);
		mv.setViewName("list-customer");
		return mv;
	}

	@GetMapping(value = "/showFormForAddCustomer")
	public ModelAndView showFormForAddCustomer() {
		ModelAndView mv = new ModelAndView();
		Customer customer = new Customer();
		mv.addObject("customer", customer);
		mv.setViewName("add-customer");
		return mv;
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		CustomerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}

	
	
	  @GetMapping("/showFormForUpdate/{id}")
	  public ModelAndView updateCustomer1(@PathVariable("id") int id) 
	  { 
		Customer customer = CustomerService.getCustomer(id);
	    ModelAndView mv =new ModelAndView();
	    mv.addObject("customer", customer); 
	    mv.setViewName("edit-customer"); 
	    return mv;
	  }
	 	  
	 
	 @GetMapping("/showFormForUpdate")
	 public ModelAndView updateCustomer(@RequestParam("customerId") int id) {
		Customer customer = CustomerService.getCustomer(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("customer", customer);
		mv.setViewName("edit-customer");
		return mv;
	}

	
	  @PostMapping("showFormForUpdate/saveCustomer") 
	  public String updateCustomer(@ModelAttribute("customer")Customer customer) 
	  {   
		  CustomerService.updateCustomer(customer);
	      return "redirect:/customer/list"; 
	  }
	 
	 @GetMapping("/deleteCustomer/{id}")
	 public String deleteCustomer1(@PathVariable("id") int id) {
		CustomerService.deleteCustomer(id);
		return "redirect:/customer/list";
	 }
	 
	 
	 @GetMapping("/deleteCustomer")
	 public String deleteCustomer(@RequestParam("customerId") int id) {
		CustomerService.deleteCustomer(id);
		return "redirect:/customer/list";
	 }
	 
	 
	 @GetMapping("/search")
	 public ModelAndView  searchCustomer(@RequestParam("searchByName")String searchByName )
	 {
		 ModelAndView mv =new ModelAndView();
		 List<Customer> customers = CustomerService.searchCustomers(searchByName);
		 mv.addObject("customers", customers);
		 mv.setViewName("list-customer");
		 return mv;
	 }

}
