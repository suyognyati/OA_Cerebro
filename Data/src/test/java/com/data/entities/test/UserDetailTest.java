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

import com.data.entities.UserDetail;
import com.data.repository.UserDetailJpaRepository;

import config.data.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class UserDetailTest {
	@Autowired
	UserDetailJpaRepository userDetailJpaRepository;
	
	@Test
	public void testBasicDetailJpaFind() {
		List<UserDetail> basicDetailList = userDetailJpaRepository.findAll();
		for (UserDetail user : basicDetailList) {
			System.out.println("\n\n\n\n Id is - " + user.getFirstName() + " Gender is - " + user.getLastName() + "\n\n\n\n");
		}
		assertNotNull(basicDetailList);
	}
	
	@Test
	public void testFindFirstName() {
		List<UserDetail> userDetailList = userDetailJpaRepository.findByFirstName("Manali");
		for (UserDetail user : userDetailList) {
			System.out.println("\n\n\n\n Id is - " + user.getFirstName() + " Gender is - " + user.getLastName() + "\n\n\n\n");
		}
		if(userDetailList != null && userDetailList.size() > 0)
			assertEquals("Manali", userDetailList.get(0).getFirstName());
		else
			assertNotNull(userDetailList);
	}
}
