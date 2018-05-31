package com.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.OccupationReservation;
import com.data.entities.Student;
import com.data.repository.OccupationReservationJpaRepository;
import com.data.services.OccupationReservationService;

@Service("occupationReservationService")
public class OccupationReservationServiceImpl implements OccupationReservationService {

	@Autowired
	OccupationReservationJpaRepository occupationReservationJpaRepository;
	
	public OccupationReservation getByStudent(Student student) {
		return occupationReservationJpaRepository.findByStudent(student);
	}
	
	public void save(OccupationReservation occupationReservation) {
		occupationReservationJpaRepository.save(occupationReservation);
	}

}
