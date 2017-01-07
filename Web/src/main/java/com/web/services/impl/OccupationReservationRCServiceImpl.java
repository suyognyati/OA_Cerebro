package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Enums;
import com.data.entities.OccupationReservation;
import com.data.services.OccupationReservationService;
import com.web.model.OccupationReservationModel;
import com.web.services.OccupationReservationRCService;
import com.web.session.Session;

@Service("occupationReservationRCService")
public class OccupationReservationRCServiceImpl implements OccupationReservationRCService {

	@Autowired
	OccupationReservationService occupationReservationService;
	
	@Autowired
	Session session;
	
	public OccupationReservationModel getOccupationReservation() {
		OccupationReservation occupationAndReservation = occupationReservationService.getByUser(session.getCurrentUser());
		OccupationReservationModel occupationAndReservationModel = new OccupationReservationModel();
		occupationAndReservationModel = setOccupationAndReservationModelObject(occupationAndReservationModel, occupationAndReservation);
		return occupationAndReservationModel;
	}

	public void saveOccupationReservation(OccupationReservationModel occupationAndReservationModel) {
		OccupationReservation occupationAndReservation = occupationReservationService.getByUser(session.getCurrentUser());
		if(occupationAndReservation == null) {
			occupationAndReservation = new OccupationReservation();
			occupationAndReservation.setUser(session.getCurrentUser());
		}
		occupationAndReservation = setOccupationAndReservationObject(occupationAndReservation, occupationAndReservationModel);
		occupationReservationService.save(occupationAndReservation);
	}
		
	private OccupationReservationModel setOccupationAndReservationModelObject(
			OccupationReservationModel occupationAndReservationModel, OccupationReservation occupationAndReservation) {
		
		if(occupationAndReservation != null) {
			occupationAndReservationModel.setIsSelfEmployed(occupationAndReservation.getIsSelfEmployed());
			occupationAndReservationModel.setExperienceYrs(occupationAndReservation.getExperienceYrs());
			occupationAndReservationModel.setExperienceMonths(occupationAndReservation.getExperienceMonths());
			occupationAndReservationModel.setOccupation(occupationAndReservation.getOccupation());
			occupationAndReservationModel.setSelfAnnualIncome(occupationAndReservation.getSelfAnnualIncome());
			occupationAndReservationModel.setIsLeaveWithoutPay(occupationAndReservation.getIsLeaveWithoutPay());
			occupationAndReservationModel.setGuardianAnnualIncome(occupationAndReservation.getGuardianAnnualIncome());
			occupationAndReservationModel.setIsEligibleForEBC(occupationAndReservation.getIsEligibleForEBC());
			occupationAndReservationModel.setCaste(occupationAndReservation.getCaste());
			occupationAndReservationModel.setCategory(occupationAndReservation.getCategory());
			occupationAndReservationModel.setReligion(occupationAndReservation.getReligion());
			occupationAndReservationModel.setMotherTongue(occupationAndReservation.getMotherTongue());
			occupationAndReservationModel.setSpeciallyAbled(occupationAndReservation.getSpeciallyAbled());
		}
		occupationAndReservationModel.setOccupationList(Enums.Occupation.getEnumList());
		occupationAndReservationModel.setCategoryList(Enums.Category.getEnumList());
		occupationAndReservationModel.setReligionList(Enums.Religion.getEnumList());
		occupationAndReservationModel.setMotherTongueList(Enums.MotherTongue.getEnumList());
		occupationAndReservationModel.setSpeciallyAbledList(Enums.SpeciallyAbled.getEnumList());
		
		return occupationAndReservationModel;
	}
	
	private OccupationReservation setOccupationAndReservationObject(OccupationReservation occupationAndReservation,
			OccupationReservationModel occupationAndReservationModel) {
		
		occupationAndReservation.setIsSelfEmployed(occupationAndReservationModel.getIsSelfEmployed());
		occupationAndReservation.setExperienceYrs(occupationAndReservationModel.getExperienceYrs());
		occupationAndReservation.setExperienceMonths(occupationAndReservationModel.getExperienceMonths());
		occupationAndReservation.setOccupation(occupationAndReservationModel.getOccupation());
		occupationAndReservation.setSelfAnnualIncome(occupationAndReservationModel.getSelfAnnualIncome());
		occupationAndReservation.setIsLeaveWithoutPay(occupationAndReservationModel.getIsLeaveWithoutPay());
		occupationAndReservation.setGuardianAnnualIncome(occupationAndReservationModel.getGuardianAnnualIncome());
		occupationAndReservation.setIsEligibleForEBC(occupationAndReservationModel.getIsEligibleForEBC());
		occupationAndReservation.setCaste(occupationAndReservationModel.getCaste());
		occupationAndReservation.setCategory(occupationAndReservationModel.getCategory());
		occupationAndReservation.setReligion(occupationAndReservationModel.getReligion());
		occupationAndReservation.setMotherTongue(occupationAndReservationModel.getMotherTongue());
		occupationAndReservation.setSpeciallyAbled(occupationAndReservationModel.getSpeciallyAbled());
		
		return occupationAndReservation;
	}

}
