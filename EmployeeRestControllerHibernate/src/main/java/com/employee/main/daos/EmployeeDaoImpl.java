package com.employee.main.daos;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.main.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {

		this.entityManager = entityManager;
	}
	

	@Override
	public List<Employee> findAll() {

		// get the current hibernate session

		Session currentsession = entityManager.unwrap(Session.class);
		// create a query
		
		Query<Employee> thequery = currentsession.createQuery("from Employee", Employee.class);

		// execute the query and get the result List
		List<Employee> employeelist = thequery.getResultList();

		// return the results
		return employeelist;

	}


	@Override
	public Employee findEmployeeById(int id) {
       
		Session currentSession = entityManager.unwrap(Session.class);
	    Employee employee = currentSession.get(Employee.class, id);
		
		return employee;
	}


	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
		
	}


	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query query =currentSession.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

}
