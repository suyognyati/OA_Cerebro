package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QualificationLevel")
public class QualificationLevel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="QualificationLevelId")
	private Integer qualificationLevelId;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="QualificationMainLevel")
	private Integer qualificationMainLevel;
	
	@Column(name="QualificationSubLevel")
	private Integer qualificationSubLevel;

		public Integer getQualificationLevelId() {
			return qualificationLevelId;
		}
	
		public void setQualificationLevelId(Integer qualificationLevelId) {
			this.qualificationLevelId = qualificationLevelId;
		}
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public String getDescription() {
			return description;
		}
	
		public void setDescription(String description) {
			this.description = description;
		}
	
		/**
		 * @return Main (Major) level of qualification
		 * */
		public Integer getQualificationMainLevel() {
			return qualificationMainLevel;
		}
	
		public void setQualificationMainLevel(Integer qualificationMainLevel) {
			this.qualificationMainLevel = qualificationMainLevel;
		}
	
		/**
		 * @return Sub (Minor) level of qualification
		 * */
		public Integer getQualificationSubLevel() {
			return qualificationSubLevel;
		}
	
		public void setQualificationSubLevel(Integer qualificationSubLevel) {
			this.qualificationSubLevel = qualificationSubLevel;
		}
}
