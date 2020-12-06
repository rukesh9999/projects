package com.employee.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.main.daos.EmployeeDao;
import com.employee.main.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

   private EmployeeDao employeeDao;
	
	
	@Autowired
    public EmployeeServiceImpl(@Qualifier(value = "employeeDaoJpaImpl") EmployeeDao employeeDao) {
	
		this.employeeDao = employeeDao;
	}

	
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		return employeeDao.findAll();
	}


	@Override
	@Transactional
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return  employeeDao.findEmployeeById(id);
	}


	@Override
	@Transactional
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
		employeeDao.save(employee);
	}


	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		employeeDao.deleteById(id);
	}

}
