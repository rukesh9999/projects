package com.cm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.model.customer;

@Service
public class CustomerService {
	@Autowired
	private com.cm.repository.CustomerRepository  CustomerRepository;
	
	
	public List<customer>  listOfCustomers()
	{
		return (List<customer>) CustomerRepository.findAll();
		
	}

	public void saveCustomer(customer customer)
	{
		CustomerRepository.save(customer);
	}
	
	
	public customer get(long id)
	{
		Optional<customer> customer= CustomerRepository.findById(id);
		return customer.get();
	}
	
	
	public void deleteCustomer(long id)
	{
		 CustomerRepository.deleteById(id);	
	}
	
	public List<customer> search(String keyword)
	{
		return CustomerRepository.search(keyword);
	}
	
}
