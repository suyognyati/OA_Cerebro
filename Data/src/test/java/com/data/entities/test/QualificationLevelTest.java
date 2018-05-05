package com.data.entities.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.data.entities.QualificationLevel;
import com.data.services.QualificationLevelService;

import config.data.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class QualificationLevelTest {
	@Autowired
	QualificationLevelService qualificationLevelService;
	
	@Test
	public void testBasicDetailJpaFind() {
		List<QualificationLevel> qualificationLevelListAsc = qualificationLevelService.getAllMainQualificationLevel();
		for (QualificationLevel qualificationLevel : qualificationLevelListAsc) {
			System.out.println("\n Qualification Name is - " + qualificationLevel.getName() + " Main Level is - " + qualificationLevel.getQualificationGroup() + " Main Level is - " + qualificationLevel.getQualificationGroupLevel() + "\n");
		}
		System.out.println("\n\n\n");
		assertNotNull(qualificationLevelListAsc);
	}
}
