package com.employee.datarest.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.employee.datarest.main.model.Employee;


@Repository
@RepositoryRestResource(path="employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	
}
