package com.sds.employeeapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.employeeapp.entity.Employee;
import com.sds.employeeapp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){	
		
		return employeeService.getAllEmployee() ;
		
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId){	
		
		Employee emp=employeeService.getEmployee(employeeId);
		
		Optional<Employee> isNull= Optional.ofNullable(emp);		
			
		if(isNull.isEmpty()) {
			
			throw new RuntimeException("Employee Not Found Exception with ID -"+employeeId);
		}
	
		return emp;
		
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee emp){	
		
		emp.setId(0);
		
		employeeService.saveEmployee(emp);
		
		return emp;
		
	}
	
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp){			
			
		employeeService.saveEmployee(emp);
		
		return emp;
		
	}
	
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId){	
		
		Employee emp=employeeService.getEmployee(employeeId);
		
		Optional<Employee> isNull= Optional.ofNullable(emp);		
			
		if(isNull.isEmpty()) {
			
			throw new RuntimeException("Employee Not Found Exception with ID -"+employeeId);
		}
	
		employeeService.deleteEmployee(employeeId);
		
		return "Deleted the employee with ID -"+employeeId;
		
	}
	

}
