package com.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="UserRoles")
public class UserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer UserRoleId;
	@ManyToOne(cascade=CascadeType.ALL)
	private User UserName;
	private String Role;
	
	public Integer getUserRoleId() {
		return UserRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		UserRoleId = userRoleId;
	}
	
	public User getUserName() {
		return UserName;
	}
	public void setUserName(User userName) {
		UserName = userName;
	}
	
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
}
