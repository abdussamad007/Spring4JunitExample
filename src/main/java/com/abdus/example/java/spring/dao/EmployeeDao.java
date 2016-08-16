package com.abdus.example.java.spring.dao;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.abdus.example.java.spring.entity.Employee;
@Transactional
public class EmployeeDao implements IEmployeeDao {
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	public void savePerson() {
		Employee person = new Employee();
		person.setId(1);
		person.setName("Ram");
		hibernateTemplate.save(person);
	}
} 