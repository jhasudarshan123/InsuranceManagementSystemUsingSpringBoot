package com.javatpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeService employeeService;
	
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}

}
