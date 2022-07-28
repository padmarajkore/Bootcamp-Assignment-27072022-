package com.example.emp.repository;

import java.util.List;

import com.example.emp.entity.Employee;



public interface EmployeeRepository {
	
	public List<Employee> findAll();

}
