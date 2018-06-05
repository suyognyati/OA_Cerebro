package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author SUYOG
 * This table is used to store category weightage to generate merit list
 * Category weightage can be in no or percentage form.
 * categoryName will be in sync with Enums.Category
 * Category name will contain 0 value for total no and 100%
 */
@Entity
@Table(name = "ProgramCategoryWeightage")
public class ProgramCategoryWeightage {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	Integer id;
	
	@Column(name="CategoryName")
	Integer categoryName;
	
	@Column(name="Weightage")
	Integer weightage;
	
	@Column(name="WeightagePercentage")
	Float weightagePercentage;
	
	@ManyToOne
	@JoinColumn(name="FK_CollegeProgram")
	CollegeProgramMap collegeProgram;
	
	@ManyToOne
	@JoinColumn(name="FK_College")
	College college;

		public Integer getId() {
			return id;
		}
	
		public void setId(Integer id) {
			this.id = id;
		}
	
		public Integer getCategoryName() {
			return categoryName;
		}
	
		public void setCategoryName(Integer categoryName) {
			this.categoryName = categoryName;
		}
	
		public Integer getWeightage() {
			return weightage;
		}
	
		public void setWeightage(Integer weightage) {
			this.weightage = weightage;
		}
	
		public Float getWeightagePercentage() {
			return weightagePercentage;
		}
	
		public void setWeightagePercentage(Float weightagePercentage) {
			this.weightagePercentage = weightagePercentage;
		}
	
		public CollegeProgramMap getCollegeProgram() {
			return collegeProgram;
		}
	
		public void setCollegeProgram(CollegeProgramMap collegeProgram) {
			this.collegeProgram = collegeProgram;
		}
	
		public College getCollege() {
			return college;
		}
	
		public void setCollege(College college) {
			this.college = college;
		}	
}
