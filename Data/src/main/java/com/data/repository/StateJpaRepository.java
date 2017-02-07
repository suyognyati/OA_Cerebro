package com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entities.Country;
import com.data.entities.State;

@Repository("stateJpaRepository")
public interface StateJpaRepository extends JpaRepository<State, Integer> {
	List<State> findByCountry(Country country);
}
