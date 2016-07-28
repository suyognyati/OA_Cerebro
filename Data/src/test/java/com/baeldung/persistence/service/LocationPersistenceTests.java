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
import com.data.repository.PersonalDetailJpaRepository;

import config.data.PersistenceConfig;

//@ContextConfiguration(locations={"classpath:com/data/db/applicationTests-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class LocationPersistenceTests {
	@Autowired
	private PersonalDetailJpaRepository personalDetailJpaRepository;

	/*@PersistenceContext
	private EntityManager entityManager;*/

	@Test
	public void testJpaFind() {
		List<PersonalDetail> personalDetail = personalDetailJpaRepository.findAll();
		for (PersonalDetail pd : personalDetail) {
			System.out.println("\n\n\n\n Id is - " + pd.getUserId() + " Gender is - " + pd.getGender() + "\n\n\n\n");
		}
		assertNotNull(personalDetail);
	}

	/*@Test
	public void testJpaAnd() {
		List<PersonalDetail> locations = personalDetailJpaRepository.findByStateNot("Utah");
		assertNotNull(locations);

		assertNotSame("Utah", locations.get(0).getState());
	}

	@Test
	public void testJpaOr() {
		List<PersonalDetail> locations = personalDetailJpaRepository.findByStateIsOrCountryEquals("Utah", "Utah");
		assertNotNull(locations);

		assertEquals("Utah", locations.get(0).getState());
	}

	@Test
	@Transactional
	public void testSaveAndGetAndDelete() throws Exception {
		PersonalDetail location = new PersonalDetail();
		location.setCountry("Canada");
		location.setState("British Columbia");
		location = personalDetailJpaRepository.saveAndFlush(location);

		// clear the persistence context so we don't return the previously cached location object
		// this is a test only thing and normally doesn't need to be done in prod code
		entityManager.clear();

		PersonalDetail otherLocation = personalDetailJpaRepository.findOne(location.getId());
		assertEquals("Canada", otherLocation.getCountry());
		assertEquals("British Columbia", otherLocation.getState());

		//delete BC location now
		personalDetailJpaRepository.delete(otherLocation);
	}

	@Test
	public void testFindWithLike() throws Exception {
		List<PersonalDetail> locs = personalDetailJpaRepository.findByStateIgnoreCaseStartingWith("new");
		assertEquals(4, locs.size());

		locs = personalDetailJpaRepository.findByStateNotLikeOrderByStateAsc("New%");
		assertEquals(46, locs.size());

		locs.forEach((location) -> {
			System.out.println(location.getState());
		});

		PersonalDetail loc = personalDetailJpaRepository.findFirstByStateIgnoreCaseStartingWith("a");
		assertEquals("Alabama", loc.getState());
	}

	@Test
	@Transactional  //note this is needed because we will get a lazy load exception unless we are in a tx
	public void testFindWithChildren() throws Exception {
		PersonalDetail arizona = personalDetailJpaRepository.findOne(3L);
		assertEquals("United States", arizona.getCountry());
		assertEquals("Arizona", arizona.getState());

		assertEquals(1, arizona.getManufacturers().size());

		assertEquals("Fender Musical Instruments Corporation", arizona.getManufacturers().get(0).getName());
	}*/
}
