package com.data.entities.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.data.entities.EducationalInformation;
import com.data.entities.University_Program;
import com.data.entities.User;
import com.data.repository.University_ProgramJpaRepository;
import com.data.repository.UserJpaRepository;
import com.data.services.EducationalInformationService;

import config.data.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class EducationalInformationTest {
	@Autowired
	EducationalInformationService educationalInformationService;
	
	@Autowired
	UserJpaRepository userJpaRepository;
	
	@Autowired
	University_ProgramJpaRepository programJpaRepository;
	
	@Test
	public void testBasicDetailJpaFind() {
		User user = userJpaRepository.findOne(1);
		University_Program program = programJpaRepository.findOne(1);
		
		List<EducationalInformation> allowedEducationalHistoryListAsc = educationalInformationService.getAllowedLastQualification(user, program);
		for (EducationalInformation allowedEducation : allowedEducationalHistoryListAsc) {
			//System.out.println("\n Qualification Name is - " + qualificationLevel.getName() + " Main Level is - " + qualificationLevel.getQualificationGroup() + " Main Level is - " + qualificationLevel.getQualificationGroupLevel() + "\n");
			System.out.println("Education Name : " + allowedEducation.getQualificationLevel().getName());
		}
		System.out.println("\n\n\n");
		assertNotNull(allowedEducationalHistoryListAsc);
	}
}
