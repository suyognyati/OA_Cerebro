package com.data.services;

import com.data.entities.OccupationReservation;
import com.data.entities.Student;

public interface OccupationReservationService {
	OccupationReservation getByStudent(Student student);
	void save(OccupationReservation occupationReservation);
}

