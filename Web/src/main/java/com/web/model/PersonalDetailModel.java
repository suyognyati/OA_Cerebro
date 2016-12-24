package com.web.model;

import java.util.List;

import com.data.entities.BloodGroup;
import com.data.entities.Enums;
import com.data.entities.Enums.MaritalStatusType;

public class PersonalDetailModel {
	
//******************** REGION NAME	
	private String lastName;
	private String firstName;
	private int relationType;
	private String middleName;
	private String mothersName;
	private String firstNameRegional;
	private String lastNameRegional;
	private String middleNameRegional;
	private Boolean isPreviousName;
	private String firstNamePrevious;
	private String lastNamePrevious;
	private String middleNamePrevious;
	private int nameChangeReason;
	
		// LastName getter setter
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		// FirstName getter setter
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		// MiddleName getter setter
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		
		// MotherName getter setter
		public String getMothersName() {
			return mothersName;
		}
		public void setMothersName(String mothersName) {
			this.mothersName = mothersName;
		}
	
		// RelationType getter setter
		public int getRelationType() {
			return relationType;
		}
		public void setRelationType(int relationType) {
			this.relationType = relationType;
		}
		
		// FirstNameRegional getter setter
		public String getFirstNameRegional() {
			return firstNameRegional;
		}
		public void setFirstNameRegional(String firstNameRegional) {
			this.firstNameRegional = firstNameRegional;
		}
		
		// LastNameRegional getter setter
		public String getLastNameRegional() {
			return lastNameRegional;
		}
		public void setLastNameRegional(String lastNameRegional) {
			this.lastNameRegional = lastNameRegional;
		}
		
		// MiddleNameRegional getter setter
		public String getMiddleNameRegional() {
			return middleNameRegional;
		}
		public void setMiddleNameRegional(String middleNameRegional) {
			this.middleNameRegional = middleNameRegional;
		}
		
		// IsPreviousName getter setter
		public Boolean getIsPreviousName() {
			return isPreviousName;
		}
		public void setIsPreviousName(Boolean isPreviousName) {
			this.isPreviousName = isPreviousName;
		}

		// FirstNamePrevious getter setter
		public String getFirstNamePrevious() {
			return firstNamePrevious;
		}
		public void setFirstNamePrevious(String firstNamePrevious) {
			this.firstNamePrevious = firstNamePrevious;
		}

		// LastNamePrevious getter setter

		public String getLastNamePrevious() {
			return lastNamePrevious;
		}
		public void setLastNamePrevious(String lastNamePrevious) {
			this.lastNamePrevious = lastNamePrevious;
		}


		
		// MidleNamePrevious getter setter
		public String getMiddleNamePrevious() {
			return middleNamePrevious;
		}
		public void setMiddleNamePrevious(String middleNamePrevious) {
			this.middleNamePrevious = middleNamePrevious;
		}

		// NameChangeReason getter setter

		public int getNameChangeReason() {
			return nameChangeReason;
		}
		public void setNameChangeReason(int nameChangeReason) {
			this.nameChangeReason = nameChangeReason;
		}

//END REGION ********************
		
//******************** REGION OTHER DETAIL
		
	private String birthDate;
	private int gender;
	private int bloodGroup;
	private String placeOfBirth;
	private int maritalStatus;
	private String adharNo;
	private List<BloodGroup> bloodGroups;
	
	
	// BirthDate getter setter
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	//Gender getter setter
	public int getGender() {
		return this.gender;
	}
	public void setGender(int genderval) {
		this.gender = genderval;
	}
	
	//Blood Group getter setter
	public int getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(int bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	//Place of Birth getter setter
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	
	//Marrital Status getter setter
	public MaritalStatusType getMaritalStatus() {
		int index = (this.maritalStatus > 0 && this.maritalStatus < 3) ? this.maritalStatus - 1 : 0;
		MaritalStatusType maritalStatus = Enums.MaritalStatusTypes[index];
		return maritalStatus;
	}
	public void setMaritalStatus(MaritalStatusType maritalStatus) {
		this.maritalStatus = maritalStatus.getValue();
	}

	//Adhar No getter setter
	public String getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}
	
	//List of Blood Group getter setter
	public List<BloodGroup> getBloodGroups() {
		return bloodGroups;
	}
	public void setBloodGroups(List<BloodGroup> bloodGroups) {
		this.bloodGroups = bloodGroups;
	}
	
//END REGION ********************	

//******************** REGION NATIONALITY DETAIL
	
	private String domiciledIn;
		
		//Domiciled In getter setter
		public String getDomiciledIn() {
			return domiciledIn;
		}
		public void setDomiciledIn(String domiciledIn) {
			this.domiciledIn = domiciledIn;
		}
				
//END REGION ********************
		
	private String flatNo;
	private String street;
	private String area;
	private String pinCode;
	private String city;
	private String state;
	
		//Flat No getter setter
		public String getFlatNo() {
			return flatNo;
		}
		public void setFlatNo(String flatNo) {
			this.flatNo = flatNo;
		}
		
		//Street getter setter
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		
		//Area getter setter
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		
		//Pin Code getter setter
		public String getPinCode() {
			return pinCode;
		}
		public void setPinCode(String pinCode) {
			this.pinCode = pinCode;
		}
		
		//City getter setter
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		
		//State getter setter
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}	
}
