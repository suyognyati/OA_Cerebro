package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.OccupationReservation;
import com.data.entities.Student;

@Repository("occupationReservationJpaRepository")
public interface OccupationReservationJpaRepository extends JpaRepository<OccupationReservation, Integer> {
	OccupationReservation findByStudent(Student student);
}
