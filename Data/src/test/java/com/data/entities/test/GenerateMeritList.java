package com.data.entities.test;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.data.entities.Application;
import com.data.poco.AppliedStudentPOCO;
import com.data.repository.CollegeProgramMapJPARepository;
import com.data.repository.ApplicationJpaRepository;

import config.data.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class GenerateMeritList {
	@Autowired
	ApplicationJpaRepository applicationsJpaRepository;
	
	@Autowired
	CollegeProgramMapJPARepository collegeProgramMapJPARepository;
	
	@Test
	public void testApplicationsJpaFind() {
		List<Application> applicationsList = applicationsJpaRepository.findAll();
		for (Application application : applicationsList) {
			System.out.println("\n\n\n\n Form No : " + application.getFormNo() + " Submitted by : " + application.getStudent().getFirstName() + "\n\n\n\n");
		}
		assertNotNull(applicationsList);
	}
	
	@Test
	public void testGeneratedMeritList() {
		//CollegeProgramMap collegeProgramMap = collegeProgramMapJPARepository.findOne(1);
		//List<Applications> applicationsList = applicationsJpaRepository.findByCollegeProgramMapId(collegeProgramMap);
		List<AppliedStudentPOCO> appliedStudentPOCOList = applicationsJpaRepository.getMeritStudents(1);
		
		for(AppliedStudentPOCO appliedStudentPOCO : appliedStudentPOCOList ) {
			System.out.println(appliedStudentPOCO.getFormNo());
		}
		assertNotNull(appliedStudentPOCOList);
	}
	
}
