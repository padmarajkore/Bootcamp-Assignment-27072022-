package com.example.emp.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.emp.entity.Employee;
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	@Autowired
	EntityManager entityManager;
	
	public List<Employee> findAll(){
		Session currentSesssion = entityManager.unwrap(Session.class);
		Query<Employee> query=currentSesssion.createQuery("select e from Employee e",Employee.class);
		List<Employee> empList=query.getResultList();
		
		return empList;
	}
}
