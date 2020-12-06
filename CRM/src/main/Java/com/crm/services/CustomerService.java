package com.crm.services;

import java.util.List;

import com.crm.entity.Customer;

public interface CustomerService {

	 List<Customer> getCustomers();
	 void saveCustomer(Customer customer);
	 Customer getCustomer(int id);
	 void updateCustomer(Customer customer);
 	 void deleteCustomer(int id);
 	 List<Customer> searchCustomers(String searchByName);

}
