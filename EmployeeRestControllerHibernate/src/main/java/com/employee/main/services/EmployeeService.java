package com.employee.main.services;

import java.util.List;

import com.employee.main.model.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findEmployeeById(int id);

	void save(Employee employee);

	void deleteById(int id);
}
