package com.sds.employeeapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sds.employeeapp.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	
	private EntityManager entityManager;
	
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		
		Session currentSession=entityManager.unwrap(Session.class);
		
		Query query=currentSession.createQuery("from Employee",Employee.class);
		
		List<Employee> employees =query.getResultList();		
		
		return employees;
	}



	@Override
	public Employee findById(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		
		Employee employee=currentSession.get(Employee.class, id);
		
		return employee;
	}



	@Override
	public void save(Employee employee) {

		Session currentSession=entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(employee);
		
		
	}



	@Override
	public void deleteById(int id) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		
		Query query=currentSession.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
		
	}

}
