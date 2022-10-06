package com.sds.employeeapp.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sds.employeeapp.dao.EmployeeDAO;
import com.sds.employeeapp.dao.EmployeeRepository;
import com.sds.employeeapp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	//@Qualifier("employeeDAOJpaImpl")
	//EmployeeDAO employeedao;
	
	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee emp=null;
		
		if(result.isPresent())   emp=result.get();
		else throw new RuntimeException("Employee Not Found "+id);
		
		return emp;
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		
		employeeRepository.save(employee);
		
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		
		employeeRepository.deleteById(id);
		
	}

}
