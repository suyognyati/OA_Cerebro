package com.data.entities.test;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.data.entities.SubmittedApplications;
import com.data.poco.AppliedStudentPOCO;
import com.data.repository.CollegeProgramMapJPARepository;
import com.data.repository.SubmittedApplicationsJpaRepository;

import config.data.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class GenerateMeritList {
	@Autowired
	SubmittedApplicationsJpaRepository submittedApplicationsJpaRepository;
	
	@Autowired
	CollegeProgramMapJPARepository collegeProgramMapJPARepository;
	
	@Test
	public void testSubmittedApplicationsJpaFind() {
		List<SubmittedApplications> submittedApplicationsList = submittedApplicationsJpaRepository.findAll();
		for (SubmittedApplications submittedApplication : submittedApplicationsList) {
			System.out.println("\n\n\n\n Form No : " + submittedApplication.getFormNo() + " Submitted by : " + submittedApplication.getUserDetail().getFirstName() + "\n\n\n\n");
		}
		assertNotNull(submittedApplicationsList);
	}
	
	@Test
	public void testGeneratedMeritList() {
		//CollegeProgramMap collegeProgramMap = collegeProgramMapJPARepository.findOne(1);
		//List<SubmittedApplications> submittedApplicationsList = submittedApplicationsJpaRepository.findByCollegeProgramMapId(collegeProgramMap);
		List<AppliedStudentPOCO> appliedStudentPOCOList = submittedApplicationsJpaRepository.getMeritStudents(1);
		
		for(AppliedStudentPOCO appliedStudentPOCO : appliedStudentPOCOList ) {
			System.out.println(appliedStudentPOCO.getFormNo());
		}
		assertNotNull(appliedStudentPOCOList);
	}
	
}
