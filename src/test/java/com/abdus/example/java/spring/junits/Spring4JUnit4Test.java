package com.abdus.example.java.spring.junits;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.abdus.example.java.spring.config.AppConfig;
import com.abdus.example.java.spring.dao.IEmployeeDao;
import com.abdus.example.java.spring.entity.Employee;

/**
 * 
 * @author abdus mondal
 *@RunWith - JUnit class reference.JUnit will invoke the class 
 *it references to run the tests in that class instead of the runner built into JUnit
 *
 *@ContextConfiguration(classes = AppConfig.class) - 
 *Spring provides SpringJUnit4ClassRunner that implements the functionality of JUnit4ClassRunner.
 * JUnit4ClassRunner is provided by JUnit. In the demo @Test is provided by SpringJUnit4ClassRunner.
 * @TransactionConfiguration(defaultRollback = true) - defines class-level metadata for configuring transactional tests.
 * This is depricated.Use @Rollback or @Commit at method level.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
//@TransactionConfiguration(defaultRollback = true)

@Transactional
public class Spring4JUnit4Test {
  @Autowired
  private IEmployeeDao personDao;
  @Autowired
  private HibernateTemplate  hibernateTemplate;
  
  @Test
  @Rollback
  public void savePersonTest(){
	  personDao.savePerson();
	  Employee person = hibernateTemplate.get(Employee.class, 1);
	  assertEquals("Ram", person.getName());
  }
}
