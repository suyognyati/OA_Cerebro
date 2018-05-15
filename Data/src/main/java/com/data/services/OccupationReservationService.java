package com.data.services;

import com.data.entities.OccupationReservation;
import com.data.entities.UserDetail;

public interface OccupationReservationService {
	OccupationReservation getByUserDetail(UserDetail userDetail);
	void save(OccupationReservation occupationReservation);
}

