package com.greatlearning.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.repository.EmployeeRepository;
import com.greatlearning.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeerepository;
	
	@Override
	public List<Employee> list() {
		
		return employeerepository.findAll();
	}

	@Override
	public void save(Employee employee) {
		employeerepository.save(employee);
		
	}
	
	@Override
	public Employee findById(Long employeeID) {
	    return employeerepository.findById(employeeID).get();
	}

	@Override
	public void deleteById(Long employeeId) {

	    employeerepository.deleteById(employeeId);		
	}

	             

	
	
	

}
