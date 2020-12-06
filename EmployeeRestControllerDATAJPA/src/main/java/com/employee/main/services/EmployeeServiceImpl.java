package com.employee.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.main.model.Employee;
import com.employee.main.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

   private EmployeeRepository employeeRepository;
	
	
	
    @Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
	
	this.employeeRepository = employeeRepository;
	
   }


	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		return employeeRepository.findAll();
	}


	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRepository.findById(id);
		//Employee employee=new Employee();
		Employee employee=null;
		if(result.isPresent())
		{
			employee = result.get();
		}	
		else {
			throw new RuntimeException("didnot not find Employee id..."+id);
		}
		return employee;
	}
	


	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
		employeeRepository.save(employee);
	}


	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

}
