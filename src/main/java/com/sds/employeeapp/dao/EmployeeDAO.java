package com.sds.employeeapp.dao;

import java.util.List;

import com.sds.employeeapp.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
    public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);

}
