package com.greatlearning.employee.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.greatlearning.employee.management.entity.Employee;
import com.greatlearning.employee.management.entity.User;
import com.greatlearning.employee.management.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employees/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return employeeService.save(employee);
		
	}
	
	@GetMapping("/employees/list")
	public List<Employee> listEmployees()
	{
		return employeeService.findAll();
		
	}
	
	@GetMapping("/employees/list/{employeeId}")
	public Employee listEmployeesByEmployeeId(@PathVariable int employeeId)
	{
		return employeeService.findById(employeeId);
		
	}
	
	@PutMapping("/employees/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee)
	{

		Employee employeeExists = employeeService.findById(employee.getId());
		if ( employeeExists == null)
		{
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "Employee not found"
					);
			
		}
		else
		{
			return employeeService.save(employee);
		}
	}
	
	@DeleteMapping("/employees/delete/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {

		Employee employee = employeeService.findById(employeeId);

		// throw exception if null

		if (employee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}

		employeeService.deleteById(employeeId);

		return "Deleted employee id - " + employeeId;
	}
	
	@GetMapping("/employees/search/{firstName}")
	public List<Employee> searchByFirstName(@PathVariable String firstName) {
		return employeeService.searchByFirstName(firstName);
	}

	@GetMapping("/employees/sort")
	public List<Employee> sortByFirstName() {
		return employeeService.sortByFirstNameAsc();
	}
	
	
	
	
}
