package com.web.services;

import com.web.model.OccupationReservationModel;

public interface OccupationReservationRCService {
	OccupationReservationModel getOccupationReservation();
	void saveOccupationReservation(OccupationReservationModel occupationReservationModel);
}
