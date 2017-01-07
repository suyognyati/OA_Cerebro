package com.data.services;

import com.data.entities.OccupationReservation;
import com.data.entities.User;

public interface OccupationReservationService {
	OccupationReservation getByUser(User user);
	void save(OccupationReservation occupationReservation);
}

