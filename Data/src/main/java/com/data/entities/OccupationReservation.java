package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="OccupationReservation")
public class OccupationReservation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="OccupationReservationId")
	private Integer occupationReservationId;

	@Column(name="IsSelfEmployed")
	private Boolean isSelfEmployed;
	
	@Column(name="ExperienceYrs")
	private String experienceYrs;
	
	@Column(name="ExperienceMonths")
	private String experienceMonths;
	
	@Column(name="Occupation")
	private Integer occupation;
	
	@Column(name="SelfAnnualIncome")
	private String selfAnnualIncome;
	
	@Column(name="IsLeaveWithoutPay")
	private Boolean isLeaveWithoutPay;
		
	@Column(name="GuardianAnnualIncome")
	private String guardianAnnualIncome;
		
	@Column(name="IsEligibleForEbc")
	private Boolean isEligibleForEBC;
	
	@Column(name="Caste")
	private String caste;

	@Column(name="Category")
	private Integer category;

	@Column(name="Religion")
	private Integer religion;
	
	@Column(name="MotherTongue")
	private Integer motherTongue;
	
	@Column(name="SpeciallyAbled")
	private Integer speciallyAbled;
	
	@OneToOne
	@JoinColumn(name="FK_UserDetail", nullable = false)
	UserDetail userDetail;
	
		//Occupation and Reservation Id
		public Integer getOccupationReservationId() {
			return occupationReservationId;
		}
		public void setOccupationReservationId(final Integer occupationReservationId) {
			this.occupationReservationId = occupationReservationId;
		}
	
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
	
		//Self Annual Income
		public String getSelfAnnualIncome() {
			return selfAnnualIncome;
		}
		public void setSelfAnnualIncome(String selfAnnualIncome) {
			this.selfAnnualIncome = selfAnnualIncome;
		}
	
		//Is applied for Leave Without Pay
		public Boolean getIsLeaveWithoutPay() {
			return isLeaveWithoutPay;
		}
		public void setIsLeaveWithoutPay(Boolean isLeaveWithoutPay) {
			this.isLeaveWithoutPay = isLeaveWithoutPay;
		}
	
		//Annual Income of Guardian
		public String getGuardianAnnualIncome() {
			return guardianAnnualIncome;
		}
		public void setGuardianAnnualIncome(String guardianAnnualIncome) {
			this.guardianAnnualIncome = guardianAnnualIncome;
		}
	
		//Is Eligible For EBC
		public Boolean getIsEligibleForEBC() {
			return isEligibleForEBC;
		}
		public void setIsEligibleForEBC(Boolean isEligibleForEBC) {
			this.isEligibleForEBC = isEligibleForEBC;
		}
		
		//Occupation
		public Integer getOccupation() {
			return occupation;
		}
		public void setOccupation(Integer occupation) {
			this.occupation = occupation;
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
	
		//Religion
		public Integer getReligion() {
			return religion;
		}
		public void setReligion(Integer religion) {
			this.religion = religion;
		}
	
		//Mother Tongue
		public Integer getMotherTongue() {
			return motherTongue;
		}
		public void setMotherTongue(Integer motherTongue) {
			this.motherTongue = motherTongue;
		}
	
		//Specially Abled
		public Integer getSpeciallyAbled() {
			return speciallyAbled;
		}
		public void setSpeciallyAbled(Integer speciallyAbled) {
			this.speciallyAbled = speciallyAbled;
		}

		//For which User
		public UserDetail getUserDetail() {
			return userDetail;
		}
		public void setUserDetail(UserDetail userDetail) {
			this.userDetail = userDetail;
		}	
	
}
