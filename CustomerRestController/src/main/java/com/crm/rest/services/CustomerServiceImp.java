package com.crm.rest.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.rest.daos.CustomerDao;
import com.crm.rest.entity.Customer;

@Service
public class CustomerServiceImp  implements CustomerService{

	@Autowired
    private  CustomerDao customerDao;
	
	@Transactional
	public List<Customer> getCustomers(){
		
		return customerDao.getCustomers();
	}
   
	@Transactional 
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(id);
	}

	@Transactional
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.updateCustomer(customer);
	}

	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(id);
	}

	public List<Customer> searchCustomers(String searchByName) {
		// TODO Auto-generated method stub
		return customerDao.getCustomers();
	}
}
