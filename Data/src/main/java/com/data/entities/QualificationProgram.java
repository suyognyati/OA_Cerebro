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
@Table(name="QualificationProgram")
public class QualificationProgram {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Integer qualificationProgramId;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Duration")
	private Integer duration;
	
	@ManyToOne
	@JoinColumn(name="FK_QualificationLevel")
	private QualificationLevel qualificationLevel;
	
		public Integer getQualificationProgramId() {
			return qualificationProgramId;
		}
	
		public void setQualificationProgramId(Integer qualificationProgramId) {
			this.qualificationProgramId = qualificationProgramId;
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
	
		public Integer getDuration() {
			return duration;
		}

		public void setDuration(Integer duration) {
			this.duration = duration;
		}

		public QualificationLevel getQualificationLevel() {
			return qualificationLevel;
		}
	
		public void setQualificationLevel(QualificationLevel qualificationLevel) {
			this.qualificationLevel = qualificationLevel;
		}
		
}
