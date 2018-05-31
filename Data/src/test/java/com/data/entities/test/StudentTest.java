package com.data.entities.test;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.data.entities.Student;
import com.data.repository.StudentJpaRepository;

import config.data.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class StudentTest {
	@Autowired
	StudentJpaRepository studentJpaRepository;
	
	@Test
	public void testBasicDetailJpaFind() {
		List<Student> basicDetailList = studentJpaRepository.findAll();
		for (Student user : basicDetailList) {
			System.out.println("\n\n\n\n Id is - " + user.getFirstName() + " Gender is - " + user.getLastName() + "\n\n\n\n");
		}
		assertNotNull(basicDetailList);
	}
	
	@Test
	public void testFindFirstName() {
		List<Student> studentList = studentJpaRepository.findByFirstName("Manali");
		for (Student user : studentList) {
			System.out.println("\n\n\n\n Id is - " + user.getFirstName() + " Gender is - " + user.getLastName() + "\n\n\n\n");
		}
		if(studentList != null && studentList.size() > 0)
			assertEquals("Manali", studentList.get(0).getFirstName());
		else
			assertNotNull(studentList);
	}
}
