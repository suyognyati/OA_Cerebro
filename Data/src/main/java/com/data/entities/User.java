package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UserId")
	private Integer userId;
	
	@Column(name="UserName")
	private String userName;

	@Column(name="Password")
	private String password;

	@Column(name="Enabled")
	private Integer enabled;
	
	@ManyToOne
	@JoinColumn(name="FK_Student")
	Student student;
	
	@ManyToOne
	@JoinColumn(name="FK_Vendor")
	Vendor vendor;
	
	@ManyToOne
	@JoinColumn(name="FK_CollegeStaff")
	CollegeStaff collegeStaff;
	
	public Integer getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public CollegeStaff getCollegeStaff() {
		return collegeStaff;
	}
	public void setCollegeStaff(CollegeStaff collegeStaff) {
		this.collegeStaff = collegeStaff;
	}
}
