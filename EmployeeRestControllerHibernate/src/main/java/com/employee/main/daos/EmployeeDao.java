package com.employee.main.daos;

import java.util.List;

import com.employee.main.model.Employee;


public interface EmployeeDao {

	 List<Employee> findAll();
	 Employee findEmployeeById(int id);
	 void save(Employee employee);
	 void deleteById(int id);
}
