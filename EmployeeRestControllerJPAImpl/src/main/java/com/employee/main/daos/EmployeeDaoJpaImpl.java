package com.employee.main.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.main.model.Employee;


@Repository
public class EmployeeDaoJpaImpl  implements EmployeeDao{

	private EntityManager EntityManager;
	
	
	@Autowired
	public EmployeeDaoJpaImpl(EntityManager entityManager) {
	
		EntityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
	  
	//create a query
	Query query=EntityManager.createQuery("from Employee", Employee.class);
		
	//execute a query and get resultlist
	 List<Employee>	employeelist =  query.getResultList();
		
	//return the results
		
		
	return employeelist;
		
	}

	@Override
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
