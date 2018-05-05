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
	
	@Column(name="QualificationGroup")
	private Integer qualificationGroup;
	
	@Column(name="QualificationGroupLevel")
	private Integer qualificationGroupLevel;
	
	@Column(name="MultiReferred")
	private Boolean multiReferred;
	
	@Column(name="CanUseAsQualificationLevel")
	private Boolean canUseAsQualificationLevel;

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
		public Integer getQualificationGroup() {
			return qualificationGroup;
		}
	
		public void setQualificationGroup(Integer qualificationGroup) {
			this.qualificationGroup = qualificationGroup;
		}
	
		/**
		 * @return Sub (Minor) level of qualification
		 * */
		public Integer getQualificationGroupLevel() {
			return qualificationGroupLevel;
		}
	
		public void setQualificationGroupLevel(Integer qualificationGroupLevel) {
			this.qualificationGroupLevel = qualificationGroupLevel;
		}

		/**
		 * @return It will return true or false
		 * <p><b>true</b> represents Qualification Level can be referred by multiple qualification of this level</p>
		 * <p><b>false</b> represents Qualification Level can be referred by only one qualification of this level</p>
		 * */
		public Boolean getMultiReferred() {
			return multiReferred;
		}

		/**
		 * @param multiReferred can be true or false
		 * <p>If true then Qualification Level can be referred by multiple qualification of this level for given user</p>
		 * <p>If false then Qualification Level can be referred by only one qualification of this level for given user</p>
		 * */
		public void setMultiReferred(Boolean multiReferred) {
			this.multiReferred = multiReferred;
		}

		/**
		 * @return It will return true or false 
		 * <p><b>true</b> represents it can be refer as qualification level</p>
		 * <p><b>false</b> represents only main level and not to be used to refer as Qualification Level</p> 
		 * */
		public Boolean getCanUseAsQualificationLevel() {
			return canUseAsQualificationLevel;
		}

		/**
		 * @param canUseAsQualificationLevel It can be true or false 
		 * <p>If true then it can be refer as qualification level</p> 
		 * <p>If false then it is only main level and not to be use to refer as Qualification Level</p> 
		 * */
		public void setCanUseAsQualificationLevel(Boolean canUseAsQualificationLevel) {
			this.canUseAsQualificationLevel = canUseAsQualificationLevel;
		}
}
