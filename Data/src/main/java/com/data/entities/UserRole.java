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
@Table(name="UserRoles")
public class UserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UserRoleId")
	private Integer userRoleId;

	@JoinColumn(name="FK_UserId")
	@ManyToOne
	private User user;

	@Column(name="Role")
	private String role;
	
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	public User getUserName() {
		return user;
	}
	public void setUserName(User userName) {
		this.user = userName;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
