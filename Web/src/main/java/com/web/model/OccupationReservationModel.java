package com.web.model;

import java.util.List;

import com.data.entities.Enums;

public class OccupationReservationModel {

//******************** REGION OCCUPATION	

	private Boolean isSelfEmployed;
	private String experienceYrs;
	private String experienceMonths;
	private Integer occupation;
	private List<Enums.KeyValuePair> occupationList;
	private String selfAnnualIncome;
	private Boolean isLeaveWithoutPay;
	private String guardianAnnualIncome;
	private Boolean isEligibleForEBC;
	private String caste;
	private Integer category;
	private List<Enums.KeyValuePair> categoryList;
	private Integer religion;
	private List<Enums.KeyValuePair> religionList;
	private Integer motherTongue;
	private List<Enums.KeyValuePair> motherTongueList;
	private Integer speciallyAbled;
	private List<Enums.KeyValuePair> speciallyAbledList;
	private Integer[] selectedSocialReservations;
	private List<Enums.KeyValuePair> socialReservationList;
	
	
		//Is Self Employed
		public Boolean getIsSelfEmployed() {
			return isSelfEmployed;
		}
		public void setIsSelfEmployed(Boolean isSelfEmployed) {
			this.isSelfEmployed = isSelfEmployed;
		}
		
		//Experience in Years
		public String getExperienceYrs() {
			return experienceYrs;
		}
		public void setExperienceYrs(String experienceYrs) {
			this.experienceYrs = experienceYrs;
		}
		
		//Experience in Months
		public String getExperienceMonths() {
			return experienceMonths;
		}
		public void setExperienceMonths(String experienceMonths) {
			this.experienceMonths = experienceMonths;
		}
		
		//Occupation
		public Integer getOccupation() {
			return occupation;
		}
		public void setOccupation(Integer occupation) {
			this.occupation = occupation;
		}
		
		//Occupation List for Dropdown Box
		public List<Enums.KeyValuePair> getOccupationList() {
			return occupationList;
		}
		public void setOccupationList(List<Enums.KeyValuePair> occupationList) {
			this.occupationList = occupationList;
		}
		
		//Self Annual Income
		public String getSelfAnnualIncome() {
			return selfAnnualIncome;
		}
		public void setSelfAnnualIncome(String selfAnnualIncome) {
			this.selfAnnualIncome = selfAnnualIncome;
		}
		
		//Leave Without Pay
		public Boolean getIsLeaveWithoutPay() {
			return isLeaveWithoutPay;
		}
		public void setIsLeaveWithoutPay(Boolean isLeaveWithoutPay) {
			this.isLeaveWithoutPay = isLeaveWithoutPay;
		}
		
		//Guardian Annual Income
		public String getGuardianAnnualIncome() {
			return guardianAnnualIncome;
		}
		public void setGuardianAnnualIncome(String guardianAnnualIncome) {
			this.guardianAnnualIncome = guardianAnnualIncome;
		}
		
		//Eligible For EBC
		public Boolean getIsEligibleForEBC() {
			return isEligibleForEBC;
		}
		public void setIsEligibleForEBC(Boolean isEligibleForEBC) {
			this.isEligibleForEBC = isEligibleForEBC;
		}
		
		//Caste
		public String getCaste() {
			return caste;
		}
		public void setCaste(String caste) {
			this.caste = caste;
		}
		
		//Category
		public Integer getCategory() {
			return category;
		}
		public void setCategory(Integer category) {
			this.category = category;
		}
		
		//Category List for Dropdown Box
		public List<Enums.KeyValuePair> getCategoryList() {
			return categoryList;
		}
		public void setCategoryList(List<Enums.KeyValuePair> categoryList) {
			this.categoryList = categoryList;
		}
		
		//Religion
		public Integer getReligion() {
			return religion;
		}
		public void setReligion(Integer religion) {
			this.religion = religion;
		}
		
		//Religion List for Dropdown Box
		public List<Enums.KeyValuePair> getReligionList() {
			return religionList;
		}
		public void setReligionList(List<Enums.KeyValuePair> religionList) {
			this.religionList = religionList;
		}
		
		//Mother Tongue
		public Integer getMotherTongue() {
			return motherTongue;
		}
		public void setMotherTongue(Integer motherTongue) {
			this.motherTongue = motherTongue;
		}
		
		//Mother Tongue List for Dropdown Box
		public List<Enums.KeyValuePair> getMotherTongueList() {
			return motherTongueList;
		}
		public void setMotherTongueList(List<Enums.KeyValuePair> motherTongueList) {
			this.motherTongueList = motherTongueList;
		}
		
		//Specially Abled
		public Integer getSpeciallyAbled() {
			return speciallyAbled;
		}
		public void setSpeciallyAbled(Integer speciallyAbled) {
			this.speciallyAbled = speciallyAbled;
		}
		
		//Specially Abled List for Dropdown Box
		public List<Enums.KeyValuePair> getSpeciallyAbledList() {
			return speciallyAbledList;
		}
		public void setSpeciallyAbledList(List<Enums.KeyValuePair> speciallyAbledList) {
			this.speciallyAbledList = speciallyAbledList;
		}
		
		//Selected social reservation list
		public Integer[] getSelectedSocialReservations() {
			return selectedSocialReservations;
		}
		public void setSelectedSocialReservations(Integer[] selectedSocialReservations) {
			this.selectedSocialReservations = selectedSocialReservations;
		}
		
		//Available social reservation list
		public List<Enums.KeyValuePair> getSocialReservationList() {
			return socialReservationList;
		}
		public void setSocialReservationList(List<Enums.KeyValuePair> socialReservationList) {
			this.socialReservationList = socialReservationList;
		}

}
