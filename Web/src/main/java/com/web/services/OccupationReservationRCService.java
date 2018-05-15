package com.web.services;

import com.data.entities.User;
import com.web.model.OccupationReservationModel;

public interface OccupationReservationRCService {
	OccupationReservationModel getOccupationReservation(User user);
	void saveOccupationReservation(OccupationReservationModel occupationReservationModel, User user);
}
