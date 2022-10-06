package com.sds.employeeapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sds.employeeapp.entity.Employee;

@Repository
public  interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
