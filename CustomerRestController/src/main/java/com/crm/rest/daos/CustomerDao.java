package com.crm.rest.daos;

import java.util.List;

import com.crm.rest.entity.Customer;

public interface CustomerDao {
	
	List<Customer> getCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomer(int id);
	void updateCustomer(Customer customer);
	void deleteCustomer(int id);
	List<Customer> searchCustomers(String searchByName);
}
