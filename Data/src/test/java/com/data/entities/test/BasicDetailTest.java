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

import com.data.entities.BasicDetail;
import com.data.repository.BasicDetailJpaRepository;

import config.data.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class BasicDetailTest {
	@Autowired
	BasicDetailJpaRepository basicDetailJpaRepository;
	
	@Test
	public void testBasicDetailJpaFind() {
		List<BasicDetail> basicDetailList = basicDetailJpaRepository.findAll();
		for (BasicDetail user : basicDetailList) {
			System.out.println("\n\n\n\n Id is - " + user.getFirstName() + " Gender is - " + user.getLastName() + "\n\n\n\n");
		}
		assertNotNull(basicDetailList);
	}
	
	@Test
	public void testFindFirstName() {
		List<BasicDetail> basicDetailList = basicDetailJpaRepository.findByFirstName("Manali");
		for (BasicDetail user : basicDetailList) {
			System.out.println("\n\n\n\n Id is - " + user.getFirstName() + " Gender is - " + user.getLastName() + "\n\n\n\n");
		}
		if(basicDetailList != null && basicDetailList.size() > 0)
			assertEquals("Manali", basicDetailList.get(0).getFirstName());
		else
			assertNotNull(basicDetailList);
	}
}
