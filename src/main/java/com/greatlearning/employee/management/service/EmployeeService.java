package com.greatlearning.employee.management.service;

import java.util.List;

import com.greatlearning.employee.management.entity.Employee;

public interface EmployeeService {
	
	public Employee save(Employee employee);
	public List<Employee> findAll();
	public Employee findById(int id);
	public List<Employee> searchByFirstName(String firstName);	
	public List<Employee> sortByFirstNameAsc();
	void deleteById(int id);
	
	

}
