package com.sds.employeeapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sds.employeeapp.entity.Employee;

@Repository("employeeDAOJpaImpl")
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		
		System.out.println("Calling the JPA");
		
		TypedQuery<Employee>  query=entityManager.createQuery("from Employee", Employee.class);
		
		List<Employee> employees=query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {

		Employee emp=entityManager.find(Employee.class, id);

		return emp;
	}

	@Override
	public void save(Employee employee) {
   
		entityManager.merge(employee);

	}

	@Override
	public void deleteById(int id) {
		
		Query query =entityManager.createQuery("delete from Employee where id=:empId");
		
		query.setParameter("empId", id);
		
		query.executeUpdate();

	}

}
