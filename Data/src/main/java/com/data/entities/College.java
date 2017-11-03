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
@Table(name="College")
public class College {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CollegeId")
	private Integer collegeId;

	@Column(name="CollegeName")
	private String collegeName;
	
	@Column(name="Address")
	private String Address;
	
	@OneToOne
	@JoinColumn(name="FK_University")
	University_University university;

		public Integer getCollegeId() {
			return collegeId;
		}
	
		public void setCollegeId(Integer collegeId) {
			this.collegeId = collegeId;
		}
	
		public String getCollegeName() {
			return collegeName;
		}
	
		public void setCollegeName(String collegeName) {
			this.collegeName = collegeName;
		}
	
		public String getAddress() {
			return Address;
		}
	
		public void setAddress(String address) {
			Address = address;
		}
	
		public University_University getUniversity() {
			return university;
		}
	
		public void setUniversity(University_University university) {
			this.university = university;
		}
	
	
}
