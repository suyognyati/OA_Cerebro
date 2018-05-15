package com.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Enums;
import com.data.entities.OccupationReservation;
import com.data.entities.User;
import com.data.services.OccupationReservationService;
import com.data.services.UserDocumentService;
import com.web.model.OccupationReservationModel;
import com.web.services.OccupationReservationRCService;

@Service("occupationReservationRCService")
public class OccupationReservationRCServiceImpl implements OccupationReservationRCService {

	@Autowired
	OccupationReservationService occupationReservationService;
	
	@Autowired
	UserDocumentService userDocumentService;
	
	public OccupationReservationModel getOccupationReservation(User user) {
		OccupationReservation occupationAndReservation = occupationReservationService.getByUserDetail(user.getUserDetail());
		OccupationReservationModel occupationAndReservationModel = new OccupationReservationModel();
		occupationAndReservationModel = setOccupationAndReservationModelObject(occupationAndReservationModel, occupationAndReservation);
		return occupationAndReservationModel;
	}

	public void saveOccupationReservation(OccupationReservationModel occupationAndReservationModel, User user) {
		OccupationReservation occupationAndReservation = occupationReservationService.getByUserDetail(user.getUserDetail());
		if(occupationAndReservation == null) {
			occupationAndReservation = new OccupationReservation();
			occupationAndReservation.setUserDetail(user.getUserDetail());
		}
		occupationAndReservation = setOccupationAndReservationObject(occupationAndReservation, occupationAndReservationModel);
		
		if(occupationAndReservation.getIsEligibleForEBC() != null) {
			if(occupationAndReservation.getIsEligibleForEBC()) {
				userDocumentService.addByDocumentFor(user.getUserDetail(), Enums.DocumentsFor.EBC.getId());
			} else {
				userDocumentService.deleteByDocumentFor(user.getUserDetail(), Enums.DocumentsFor.EBC.getId());
			}
		}
		
		if(occupationAndReservation.getCategory() == Enums.Category.GEN.getId()) {
			userDocumentService.deleteByDocumentFor(user.getUserDetail(), Enums.DocumentsFor.Caste.getId());
		} else {
			userDocumentService.addByDocumentFor(user.getUserDetail(), Enums.DocumentsFor.Caste.getId());
		}
		
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
