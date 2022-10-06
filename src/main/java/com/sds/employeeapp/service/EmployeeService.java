package com.sds.employeeapp.service;

import java.util.List;

import com.sds.employeeapp.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployee(int id);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployee(int id);

}
