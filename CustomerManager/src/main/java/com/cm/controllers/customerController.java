package com.cm.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cm.model.customer;
import com.cm.services.CustomerService;

@Controller
public class customerController {

	@Autowired
	private CustomerService customerService;
	@RequestMapping("/index.htm")
	public ModelAndView  home()
	{
		ModelAndView mv =new ModelAndView();
		List<customer> listOfCustomers = customerService.listOfCustomers();
		mv.addObject("listOfCustomers", listOfCustomers);
		mv.setViewName("index");
		return mv;
			
	}
	
	
	
	@RequestMapping("/new.htm")
	public String newCustomer()
	{
	   
		return "newcustomer";
	
	}
	
	
	@RequestMapping(value="/savecustomer.htm",method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("savecustomer") customer customer)
	{
		
		customerService.saveCustomer(customer);
		return "index";
	}
	
	
	@RequestMapping("/edit.htm")
	public ModelAndView  editCustomer(@RequestParam long id)
	{
		
		ModelAndView mv =new ModelAndView();
		customer  customer =customerService.get(id);
		mv.addObject("customer", customer);
		mv.setViewName("editcustomer");
		return mv;
	}
	
	@RequestMapping("/delete.htm")
	public String deleteCustomer(@RequestParam long id)
	{
		customerService.deleteCustomer(id);	
		return "index";
	}
	
	@RequestMapping("/search.htm")
	public ModelAndView search(@RequestParam String keyword)
	{
		ModelAndView mv =new ModelAndView();
		List<customer> searchcustomer = customerService.search(keyword);
		mv.addObject("searchcustomer", searchcustomer);
		mv.setViewName("searchResult");
		return mv;
	}
	
}
