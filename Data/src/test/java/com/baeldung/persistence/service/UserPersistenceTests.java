package com.baeldung.persistence.service;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.data.entities.PersonalDetail;
import com.data.entities.User;
import com.data.repository.PersonalDetailJpaRepository;
import com.data.repository.UserJpaRepository;

import config.data.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class UserPersistenceTests {
	@Autowired
	private PersonalDetailJpaRepository personalDetailJpaRepository;

	@Autowired
	UserJpaRepository userJpaRepository;
	
	@Test
	public void testJpaFind() {
		List<PersonalDetail> personalDetail = personalDetailJpaRepository.findAll();
		for (PersonalDetail pd : personalDetail) {
			System.out.println("\n\n\n\n Id is - " + pd.getUserId() + " Gender is - " + pd.getGender() + "\n\n\n\n");
		}
		assertNotNull(personalDetail);
	}
	
	@Test
	public void testBasicDetailJpaFind() {
		List<User> users = userJpaRepository.findAll();
		for (User user : users) {
			System.out.println("\n\n\n\n Id is - " + user.getFirstName() + " Gender is - " + user.getLastName() + "\n\n\n\n");
		}
		assertNotNull(users);
	}
}
