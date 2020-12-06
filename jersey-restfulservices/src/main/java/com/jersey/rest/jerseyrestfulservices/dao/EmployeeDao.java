package com.jersey.rest.jerseyrestfulservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jersey.rest.jerseyrestfulservices.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	Employee findByName(String name);

}
