package com.crm.rest.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.crm.rest.entity.Customer;

@Repository
public class CustomerDaoImpl  implements CustomerDao{
  
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
	    List<Customer> listOfCustomers =	hibernateTemplate.loadAll(Customer.class);
		return listOfCustomers;
	}

	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(customer);
	}

	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Customer.class, id);
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(customer);
	}

	
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(getCustomer(id));
	}

	
	 public List<Customer> searchCustomers(String searchByName) {
		// TODO Auto-generated method stub
	   List<Customer> listofCustomers=null;
	   
	   if(searchByName!=null && searchByName.trim().length()>0)
	   {
		   //search for firstName or lastname
			 listofCustomers = (List<Customer>) hibernateTemplate.findByNamedQuery("byfirstName", searchByName);
	   }
	   
	   else {
		   
		   listofCustomers =	hibernateTemplate.loadAll(Customer.class);
	   }
		
	    return  listofCustomers;
	
	 }

}
