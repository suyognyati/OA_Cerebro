package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProgramCategory")
public class ProgramCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CategoryId")
	Integer categoryId;
	
	@Column(name="CategoryName")
	String categoryName;

		public Integer getCategoryId() {
			return categoryId;
		}
	
		public void setCategoryId(Integer categoryId) {
			this.categoryId = categoryId;
		}
	
		public String getCategoryName() {
			return categoryName;
		}
	
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
}
